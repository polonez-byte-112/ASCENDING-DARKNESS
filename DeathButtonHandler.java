package com.polonez11212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeathButtonHandler implements ActionListener {
    Start start;
    Slides slides;


    public DeathButtonHandler(Slides slides){

        this.slides=slides;
        this.start=slides.start;
/*
        this.deathTimer=deathTimer;
        this.start=deathTimer.start;
        this.slides=deathTimer.slides;
 */

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command =e.getActionCommand();
        switch (command){
            case "again": slides.buttonDeathPanel.setVisible(false); slides.GameOver.setVisible(false); new Slides(start); break;
            case "nope":  start.setVisible(false);break;
            default: break;
        }
    }
}
