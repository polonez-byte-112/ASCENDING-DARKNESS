package com.polonez11212;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;


public class TimerItem  implements KeyListener {
    Casual casual;
    Start start;
    Slides slides;
    PlayerVariables pv;
    Timer timerI;
    HashSet<Integer> pressedItem = new HashSet<Integer>();
    public TimerItem(Casual casual){
        this.casual=casual;
        this.start=casual.start;
        this.slides=casual.slides;
        this.pv=casual.pv;




setTimerI();

    }

    public void setTimerI(){
        timerI =new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pressedItem.contains(KeyEvent.VK_R)){
                    casual.usedItem();
                    timerI.stop();

                }else if(pressedItem.contains(KeyEvent.VK_T)){
                    casual.throwedItem();
                    timerI.stop();
                }else{}
            }
        });

        timerI.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        pressedItem.add(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressedItem.remove(e.getKeyCode());
    }
}
