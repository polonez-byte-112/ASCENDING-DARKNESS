package com.polonez11212;


import javax.swing.*;
import java.awt.event.*;
import java.util.HashSet;

public class TimerMoving implements KeyListener{
Timer timerM;
Casual casual;
Slides slides;
Start start;
    public String directionChoose="";
    PlayerVariables pv;
    private final HashSet<Integer> pressed = new HashSet<Integer>();
    public TimerMoving( Casual casual){

        this.casual=casual;
        this.slides=casual.slides;
        this.start=casual.start;
        this.pv= casual.pv;



        setTimerM();

    }

    public void setTimerM(){
        timerM =new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {

                if(pressed.contains(KeyEvent.VK_Q)){

                    directionChoose="Path";
                    casual.switchSlides();
                    timerM.stop();
                }else if(pressed.contains(KeyEvent.VK_E)){

                    directionChoose="Mud";
                    casual.switchSlides();
                    timerM.stop();
                }
            }
        });

        timerM.start();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e){
        pressed.add(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {

        pressed.remove(e.getKeyCode());

    }

}
