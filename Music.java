package com.polonez11212;

import javax.sound.sampled.*;
import java.io.File;

public class Music {

    Clip clip;

    void setMusic(String filePath){

        try{

            File file= new File(filePath);
            AudioInputStream stream = AudioSystem.getAudioInputStream(file);
            
            clip= AudioSystem.getClip();
            clip.open(stream);

        }catch (Exception e){
            System.out.println("Exception has been throwd");
        }

    }

    void startMusic(){
        clip.setFramePosition(0);
        clip.start();
    }

    void loopMusic(int music){
        clip.loop(music);
    }
    void stopMusic(){
        clip.stop();
        clip.close();
    }
}
