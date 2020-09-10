package com.polonez11212;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class DeathTimer extends JPanel{

    Casual casual;
    Start start;
    Slides slides;
    Timer timer;
    Fonts fonts=new Fonts();
    Colors colors=new Colors();
    DeathButtonHandler deathButtonHandler;
    PlayerVariables pv;

    boolean deadthOn=false;

    public DeathTimer(Casual casual){
         this.casual=casual;
         this.slides=casual.slides;
         this.pv=casual.pv;
         this.start=casual.start;
        deathButtonHandler = new DeathButtonHandler(slides);

        setTimerD();
        timer.start();
    }

    public void setTimerD(){
        timer= new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((pv.playerHP<=0)||(pv.playerWater<=0)){

                    System.out.println("Smierć i elo");
                    deadthOn=true;
                 if(deadthOn==true){   isDeath();}
                    pv.playerHP=0; pv.playerWater=0;

                    timer.stop();

                }
            }
        });
        timer.start();
    }


    public void isDeath(){
        slides.photoPanel.setVisible(false);
        slides.variablesPanel.setVisible(false);
        slides.textPanel.setVisible(false);
        slides.descriptionPanel.setVisible(false);
        slides.dayCounter.setVisible(false);

        slides.GameOver=new JTextArea();
        slides.GameOver.setText("            GAME OVER\n\n  Do You want to PLAY AGAIN?");
        slides.GameOver.setWrapStyleWord(true);
        slides.GameOver.setEditable(false);
        slides.GameOver.setFont(fonts.playerVariablesFont.deriveFont(60f));
        slides.GameOver.setForeground(colors.layoutDescriptionLabelColor);
        slides.GameOver.setBounds(200,200,500,200);
        slides.GameOver.setOpaque(false);
        start.add(slides.GameOver);


        slides.buttonDeathPanel= new JPanel();
        slides.buttonDeathPanel.setLayout(new GridLayout(1,2,20,0));
        slides.buttonDeathPanel.setBackground(colors.layoutBackgroundColor);
        slides.buttonDeathPanel.setBounds(300,550,300,130);

        slides.death1=new JButton("YES");
        slides.death1.setFocusPainted(false);
        slides.death1.setBorder(null);
        slides.death1.setBackground(colors.layoutTextBackgroundColor);
        slides.death1.setFont(fonts.titleButtonFont.deriveFont(40f));
        slides.death1.setForeground(colors.variablesColor);
        slides.death1.addActionListener(deathButtonHandler);
        slides.death1.setActionCommand("again");
        slides.buttonDeathPanel.add(slides.death1);


        slides.death2=new JButton("NO");
        slides.death2.setFocusPainted(false);
        slides.death2.setBorder(null);
        slides.death2.setBackground(colors.layoutTextBackgroundColor);
        slides.death2.setFont(fonts.titleButtonFont.deriveFont(40f));
        slides.death2.addActionListener(deathButtonHandler);
        slides.death2.setActionCommand("nope");
        slides.death2.setForeground(colors.variablesColor);
        slides.buttonDeathPanel.add(slides.death2);


        start.add(slides.buttonDeathPanel);
    }


}
