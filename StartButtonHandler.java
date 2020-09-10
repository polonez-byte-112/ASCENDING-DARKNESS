package com.polonez11212;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartButtonHandler implements ActionListener {
    Start start;



    public StartButtonHandler(Start start){
        this.start=start;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
 new Slides(start);

    }

}
