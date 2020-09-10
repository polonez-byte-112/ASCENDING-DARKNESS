package com.polonez11212;

import jdk.swing.interop.SwingInterOpUtils;

public class Casual {


    Slides slides;
    Thread musicThread = new Thread(new Music());
    Start start;
    Picture picture;

    PlayerVariables pv ;
    TimerMoving tm = new TimerMoving(this) ;
    TimerAction ta=new TimerAction(this);
    TimerItem   ti= new TimerItem(this);



    String wuwtd="\n\nWhere do You want to go?\n\n[Q] Go forest Pathway  [E] Go Muddy road";
    String wuwtdtwo="\nWhat do You want to do?\n\n";
    String checkAreaText="[I] Check Area ";
    String sleepText=" [O] Sleep over ";
    String huntText=" [P] Hunt";
    String aheadText=" [L] Go ahead ";
    String regenerateText;

String fullTextAction= wuwtdtwo+checkAreaText+sleepText+huntText+aheadText;




         public Casual(Slides slides){

this.slides=slides;
this.start=slides.start;
this.pv=slides.pv;
this.picture=slides.picture;



    }
         public void firstDay(){
        slides.currentSlide="firstDay";
        musicThread.start();
             new DeathTimer(this);

         slides.textPanel.setText("You had the accident in forrest.\nYou take all u got and go into adventure."+wuwtd);
       start.addKeyListener(tm);


   }
         public void forestUniversalPath(){
             slides.currentSlide="forestPath";
             picture.setPicture();
            pv.playerWater=pv.playerWater-pv.walkWaterLoss;
            slides.playerMPLabel.setText(pv.playerWater+" UNITS");
            pv.thisNightSleep=false;
            start.addKeyListener(ta);

            if(pv.thisNightSleep==false){
                slides.textPanel.setText("You walk Forest " + tm.directionChoose + "\nYou lost "+pv.walkWaterLoss+" Water"+fullTextAction);
            }

         }
         public void checkArea(){


         if(pv.areaChecked==false){
             slides.currentSlide="checkArea";
             picture.setPicture();
             pv.areaChecked=true;
         pv.generateItem();
         String checkItem = "";

                             if(pv.kindOfItem=="Food")
                             { checkItem="Eat it";}

                             else if(pv.kindOfItem=="Water"){
                                 checkItem="Drink it";
                             }
                             else if(pv.kindOfItem=="Tool")
                             {
                                checkItem="Take it";

                             }else{}


         slides.textPanel.setText("You checked area.\n\nItem Found: "+ pv.currentRandomItem+"\nItem Category: "+pv.kindOfItem+wuwtdtwo+"[R] "+checkItem+"  [T] Throw away");
         start.addKeyListener(ti);
         ti.timerI.start();
             ta.timerA.stop();

         }}
         public void usedItem(){
             if(pv.usedChecked==false) {
                 pv.usedChecked=true;
                 slides.currentSlide = "usedItem";
                 picture.setPicture();
                 ti.timerI.stop();
                 String itemused = "";
                 ta.setTimerA();
                 ta.timerA.start();
                 if (pv.kindOfItem == "Food") {
                     itemused = "Eated";
                     pv.currentFoodOrItem = pv.foodRestoredHp;
                 } else if (pv.kindOfItem == "Water") {
                     itemused = "Drinked";
                     pv.currentFoodOrItem = pv.waterRestoreHp;
                 } else if (pv.kindOfItem == "Tool") {
                     itemused = "Taked";
                     slides.playerWeaponLabel.setText(pv.currentRandomItem + "");
                     pv.currentFoodOrItem = 0;
                 } else {
                 }
                 if (pv.currentFoodOrItem == pv.foodRestoredHp) {
                     regenerateText = "\nThis food restored You " + pv.foodRestoredHp + " HP\n\n";
                 } else if (pv.currentFoodOrItem == pv.waterRestoreHp) {
                     regenerateText = "\nThis water restored You " + pv.foodRestoredHp + " Units\n\n";
                 } else {
                     regenerateText = "";
                 }
                 slides.playerHPLabel.setText(pv.playerHP + " HP");
                 slides.playerMPLabel.setText(pv.playerWater + " UNITS");
                 if (pv.thisNightSleep == true) {
                     sleepText = "";
                 }
                 if (pv.areaChecked == true) {
                     checkAreaText = "";
                 }
                 if (pv.huntingChecked == true) {
                     huntText = "";
                 }

                 slides.textPanel.setText("You " + itemused + " a " + pv.currentRandomItem + regenerateText + wuwtdtwo + sleepText + huntText + aheadText);
             } }
         public void throwedItem(){
if(pv.throwChecked==false){
pv.throwChecked=true;
    slides.currentSlide="throwedItem";
    picture.setPicture();
    ti.timerI.stop();
    ta.setTimerA();
    ta.timerA.start();


    if(pv.thisNightSleep==true){sleepText="";}
    if(pv.areaChecked==true){checkAreaText="";}
    if(pv.huntingChecked==true){huntText="";}

    slides.textPanel.setText("You throwed a "+ pv.currentRandomItem+"!"+wuwtdtwo+sleepText+huntText+aheadText);
}
    }
         public void sleepNight(){

if(pv.sleepChecked==false){
    pv.sleepChecked=true;
          if(pv.thisNightSleep==false){
              slides.currentSlide="sleepNight";
              picture.setPicture();

              if(pv.thisNightSleep==true){sleepText="";}else{sleepText=" [O] Sleep over ";}
              if(pv.areaChecked==true){checkAreaText="";}else{checkAreaText="[I] Check Area ";}
              if(pv.huntingChecked==true){huntText="";}else{huntText=" [P] Hunt";}
              if(pv.goAheadChecked==true){aheadText="";}else{aheadText=" [L] Go ahead ";}



              slides.ammountOfDays++;
              slides.dayCounter.setText("DAYS "+ slides.ammountOfDays);pv.daysdisable=true;
                pv.thisNightSleep=true;
              pv.playerHP=pv.playerHP+5;
              slides.playerHPLabel.setText(pv.playerHP+" HP");
              slides.textPanel.setText("You slept all Night.\n\nIn sleep You recover 5HP"+wuwtdtwo+checkAreaText+huntText+aheadText);
              ta.setTimerA();
              ta.timerA.start();
          }}
         }
         public void hunt(){


             
         if(pv.huntingChecked==false){
            pv.huntingChecked=true;
             slides.currentSlide="hunt";
             picture.setPicture();

             if(pv.thisNightSleep==true){sleepText="";}else{sleepText=" [O] Sleep over ";}
             if(pv.areaChecked==true){checkAreaText="";}else{checkAreaText="[I] Check Area ";}
             if(pv.huntingChecked==true){huntText="";}else{huntText=" [P] Hunt";}
             if(pv.goAheadChecked==true){aheadText="";}else{aheadText=" [L] Go ahead ";}
             pv.randomKillAnimal();
             String message="";
             if(pv.failedHunt==false){message="Congratulations!\n\nYou killed "+ pv.nameofAnimal +wuwtdtwo+checkAreaText+sleepText+aheadText;  slides.playerHPLabel.setText(pv.playerHP+" HP");
                 slides.playerMPLabel.setText(pv.playerWater+" UNITS");}else if(pv.failedHunt){message="Unfortunatly You missed"+wuwtdtwo+checkAreaText+sleepText+aheadText;}
             slides.textPanel.setText(message);
             ta.setTimerA();
             ta.timerA.start();
         }
         }
         public void goAhead(){
             if(pv.goAheadChecked==false){

           slides.ammountOfDays=slides.ammountOfDays+1;
             slides.dayCounter.setText("DAYS "+ slides.ammountOfDays);
        slides.currentSlide="goAhead";
                 picture.setPicture();
             slides.textPanel.setText("Lets go ahead then. There is two paths ahead. "+wuwtd);
             tm.directionChoose="";
             pv.areaChecked=false;
             pv.huntingChecked=false;
             pv.goAheadChecked=true;
             pv.thisNightSleep=false;
             pv.usedChecked=false;
             pv.throwChecked=false;
              pv.sleepChecked=false;
                 if(pv.thisNightSleep==true){sleepText="";}else{sleepText=" [O] Sleep over ";}
                 if(pv.areaChecked==true){checkAreaText="";}else{checkAreaText="[I] Check Area ";}
                 if(pv.huntingChecked==true){huntText="";}else{huntText=" [P] Hunt";}
                 if(pv.goAheadChecked==true){aheadText="";}else{aheadText=" [L] Go ahead ";}
             tm.timerM.start();
             ti.timerI.start();
             ti.timerI.start();
             ta.setTimerA();
             ta.timerA.start();

         }}
         public void switchSlides(){
        forestUniversalPath(); pv.goAheadChecked=false;
    }
}
