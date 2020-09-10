package com.polonez11212;

import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;

public class TimerAction implements KeyListener {
    Timer timerA;
    Casual casual;
    Start start;
    Slides slides;
    PlayerVariables pv;
    HashSet<Integer> pressedAction = new HashSet<Integer>();
    public TimerAction(Casual casual){

        this.casual=casual;
        this.start=casual.start;
        this.slides=casual.slides;
        this.pv=casual.pv;


        setTimerA();

    }

    public void setTimerA(){
        timerA = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pressedAction.contains(KeyEvent.VK_I)){

                    casual.checkArea();
                    timerA.stop();
                }
                else if(pressedAction.contains(KeyEvent.VK_O)){
                            casual.sleepNight();
                            timerA.stop();
                }else if(pressedAction.contains(KeyEvent.VK_P)){
                    casual.hunt();
                    timerA.stop();
                }else if(pressedAction.contains(KeyEvent.VK_L)){
                    casual.goAhead();
                    timerA.stop();
                }else{}
            }
        });
        timerA.start();
    }



    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e){
        pressedAction.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedAction.remove(e.getKeyCode());
    }
}
