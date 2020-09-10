package com.polonez11212;

import javax.swing.*;
import java.awt.*;

public class Slides {


    Start start;
    Colors colors=new Colors();
    PlayerVariables pv = new PlayerVariables();
    Fonts fonts = new Fonts();
    Picture picture = new Picture(this);



    JPanel  variablesPanel;
    JTextArea textPanel;
     JLabel photoPanel;
    JLabel playerHPLabel,dayCounter;
    JLabel playerMPLabel;
    JLabel playerWeaponLabel;
    JTextArea descriptionPanel;
     ImageIcon icon;
     String imageDirectory=".//res/img/";
     String currentSlide;
     int ammountOfDays=1;
    int imageNumber=1;
    String currentImage=imageNumber+".jpg";

    JTextArea GameOver;

    JPanel buttonDeathPanel;
    JButton death1, death2;


    Slides(Start start){
        new Fonts();
        this.start=start;

    deleteStartLayout();
    createNewLayout();

    }





    private void deleteStartLayout(){
        start.titleTextLabel.setVisible(false);
        start.titleTextShadow.setVisible(false);
        start.titleButton.setVisible(false);
    }

    private void createNewLayout() {

        dayCounter=new JLabel();
        dayCounter.setText("Day "+ammountOfDays);
        dayCounter.setBounds(700,20,100,50);
        dayCounter.setForeground(Color.RED);
        dayCounter.setFont(fonts.playerVariablesFont);
        start.add(dayCounter);

        pv.playerHP=100;
        pv.playerWater=100;
        pv.playerWeaponName="Knife";
        icon=new ImageIcon(imageDirectory+currentImage+"");
        photoPanel=new JLabel();
        photoPanel.setBounds(50,30,600,400);
        photoPanel.setIcon(icon);
        photoPanel.setFocusable(false);
        start.add(photoPanel);

        variablesPanel=new JPanel();
        variablesPanel.setBounds(700,30,250,400);
        variablesPanel.setBackground(colors.layoutBackgroundColor);
        variablesPanel.setFocusable(false);
        variablesPanel.setLayout(new GridLayout(3,2));


        JLabel healthL = new JLabel("Health: ");
        healthL.setForeground(colors.variablesColor);
        healthL.setFont(fonts.playerVariablesFont);
        variablesPanel.add(healthL);

        playerHPLabel=new JLabel(pv.playerHP+" HP");
        playerHPLabel.setForeground(colors.variablesColor);
        playerHPLabel.setFont(fonts.playerVariablesFont);
        variablesPanel.add(playerHPLabel);

        JLabel manaL =new JLabel("Water: ");
        manaL.setForeground(colors.variablesColor);
        manaL.setFont(fonts.playerVariablesFont);
        variablesPanel.add(manaL);

        playerMPLabel=new JLabel(""+pv.playerWater+" UNITS");
        playerMPLabel.setForeground(colors.variablesColor);
        playerMPLabel.setFont(fonts.playerVariablesFont);
        variablesPanel.add(playerMPLabel);

        JLabel weaponL = new JLabel("Weapon: ");
        weaponL.setForeground(colors.variablesColor);
        weaponL.setFont(fonts.playerVariablesFont);
        variablesPanel.add(weaponL);

        playerWeaponLabel=new JLabel(pv.playerWeaponName+"");
        playerWeaponLabel.setForeground(colors.variablesColor);
        playerWeaponLabel.setFont(fonts.playerVariablesFont);
        variablesPanel.add(playerWeaponLabel);

        start.add(variablesPanel);

        textPanel=new JTextArea("This is main Text Area. If You see this, this is displaying properly");
        textPanel.setFocusable(false);
        textPanel.setForeground(colors.layoutTextColor);
        textPanel.setBackground(colors.layoutTextBackgroundColor);
        textPanel.setBounds(50,480,700,250);
        textPanel.setWrapStyleWord(true);
        textPanel.setFocusable(false);
        textPanel.setLineWrap(true);
        textPanel.setFont(fonts.textFont);
        textPanel.setEditable(false);
        start.add(textPanel);

        descriptionPanel=new JTextArea("Use \"WASD\" or arrows to navigate.\n\nHave fun!");
        descriptionPanel.setWrapStyleWord(true);
        descriptionPanel.setFocusable(false);
        descriptionPanel.setLineWrap(true);
        descriptionPanel.setEditable(false);
        descriptionPanel.setOpaque(false);
        descriptionPanel.setFont(fonts.descriptionFont);
        descriptionPanel.setBounds(800,530,150,100);
        descriptionPanel.setForeground(colors.layoutDescriptionLabelColor);
        start.add(descriptionPanel);
        start.repaint();
        new Casual(this).firstDay();

    }


}
