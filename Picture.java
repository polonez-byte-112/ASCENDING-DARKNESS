package com.polonez11212;

import javax.swing.*;

public class Picture {

    Slides slides;
    Start start;
    public Picture(Slides slides){
        this.slides=slides;
        this.start=slides.start;


    }

    public void setPicture(){

          ImageIcon icon2;
          ImageIcon icon5;
          ImageIcon icon6;
          ImageIcon icon7;


        icon2= new ImageIcon(".//res/img/2.jpg");

        icon5= new ImageIcon(".//res/img/5.jpg");

        icon6= new ImageIcon(".//res/img/6.jpg");

        icon7= new ImageIcon(".//res/img/7.jpg");





        switch (slides.currentSlide){
            case "forestPath": slides.photoPanel.setIcon(icon2);   break;
            case "checkArea":
            case "usedItem":
            case "throwedItem":  slides.photoPanel.setIcon(icon5);  break;
            case "sleepNight":  slides.photoPanel.setIcon(icon6);  break;
            case "hunt": slides.photoPanel.setIcon(icon7);  break;
            case "goAhead":  slides.photoPanel.setIcon(slides.icon);  break;
        }


    }
}
