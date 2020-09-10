package com.polonez11212;

import javax.swing.*;
import java.awt.*;

public class Start extends JFrame  {





   Fonts fonts= new Fonts();
   Colors colors= new Colors();
    JLabel titleTextLabel, titleTextShadow;
    JButton titleButton;
   StartButtonHandler startButtonHandler=new StartButtonHandler(this);

    Start(){
        this.setTitle("Ascending Darkness");
        this.setSize(1000,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.darkGray);
        this.setFocusable(true);



        setUpStart();

        this.setVisible(true);
    }

  private   void setUpStart(){
      new Fonts();
      titleTextLabel=new JLabel();
      titleTextLabel.setBounds(200,150,600,150);
      titleTextLabel.setFont(fonts.titleFont);
      titleTextLabel.setForeground(colors.titleColor);
      titleTextLabel.setHorizontalAlignment(JLabel.CENTER);
      titleTextLabel.setVerticalAlignment(JLabel.CENTER);
      titleTextLabel.setText("ASCENDING  DARKNESS");
      titleTextLabel.setBackground(Color.WHITE);
      this.add(titleTextLabel);



      titleTextShadow=new JLabel();
      titleTextShadow.setBounds(210,165,600,150);
      titleTextShadow.setFont(fonts.titleFont);
      titleTextShadow.setForeground(colors.titleShadowColor);
      titleTextShadow.setHorizontalAlignment(JLabel.CENTER);
      titleTextShadow.setVerticalAlignment(JLabel.CENTER);
      titleTextShadow.setText("ASCENDING DARKNESS");
      titleTextShadow.setBackground(Color.WHITE);
      this.add(titleTextShadow);



      titleButton= new JButton("S T A R T");
      titleButton.setHorizontalAlignment(JButton.CENTER);
      titleButton.setVerticalAlignment(JButton.CENTER);
      titleButton.setBounds(400,500,200,100);
      titleButton.setFocusPainted(false);
      titleButton.setBackground(colors.layoutTextBackgroundColor);
      titleButton.setBorder(null);
      titleButton.addActionListener(startButtonHandler);
      titleButton.setForeground(colors.titleColor);
      titleButton.setFont(fonts.titleButtonFont);
      this.add(titleButton);



    }
}
