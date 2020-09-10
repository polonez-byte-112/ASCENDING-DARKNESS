package com.polonez11212;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Fonts  {




    Font titleFont;
    Font titleButtonFont;
    Font playerVariablesFont;
    Font descriptionFont;
    Font textFont;

    {
        try {
            titleFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(".//res/fonts/Championship.ttf"))).deriveFont(60f);
            titleButtonFont= Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(".//res/fonts/north.otf"))).deriveFont(50f);
            playerVariablesFont=titleButtonFont.deriveFont(40f);
            descriptionFont=Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File(".//res/fonts/futuristFixed.TTF"))).deriveFont(15f);
            textFont=Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File(".//res/fonts/CodeSaver.otf"))).deriveFont(20f);

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
