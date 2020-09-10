package com.polonez11212;

public class PlayerVariables {

        int playerHP;
        int playerWater;
        int walkWaterLoss=10;
        int randomItemNumber,randomAnimalKill;
        String nameofAnimal;
        String playerWeaponName;
        String currentRandomItem;
        String musicDay = ".//res/music/forestDay.wav";
        String kindOfItem;


        boolean thisNightSleep=false;
        boolean areaChecked=false;
        boolean huntingChecked=false;
        boolean daysdisable=false;
        boolean failedHunt;
        boolean goAheadChecked=false;
        boolean usedChecked=false;
        boolean throwChecked=false;
        boolean sleepChecked=false;

        int foodRestoredHp;
        int waterRestoreHp;
        int currentFoodOrItem;




        public void generateItem(){
            randomItemNumber =(int)Math.floor(Math.random()*9)+1;
            switch (randomItemNumber){
                case 1:
                case 2:
                case 3: kindOfItem="Food"; break;

                case 4:
                case 5:
                case 6: kindOfItem="Water"; break;

                case 7:
                case 8:
                case 9: kindOfItem="Tool"; break;

            }
            switch (randomItemNumber){
                case 1: currentRandomItem="Tuna Can";  foodRestoredHp =35; playerHP=playerHP+foodRestoredHp;break;
                case 2: currentRandomItem="Berries";foodRestoredHp =15; playerHP=playerHP+foodRestoredHp;break;
                case 3: currentRandomItem="Mushroom";foodRestoredHp =5;playerHP=playerHP+foodRestoredHp; break;

                case 4: currentRandomItem="Water bottle"; waterRestoreHp=36; playerWater=playerWater+waterRestoreHp; break;
                case 5: currentRandomItem="Half Empty Juice"; foodRestoredHp =6;playerWater=playerWater+waterRestoreHp;break;
                case 6: currentRandomItem="Honey Pot";foodRestoredHp =16;playerWater=playerWater+waterRestoreHp; break;

                case 7: currentRandomItem="Hammer"; foodRestoredHp=0;break;
                case 8: currentRandomItem="Sharp Stick"; foodRestoredHp=0;break;
                case 9: currentRandomItem="Torch"; foodRestoredHp=0;break;
            }
        }
        public void randomKillAnimal(){
            randomAnimalKill= (int)Math.floor(Math.random()*13)+1;


            switch (randomAnimalKill){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9: failedHunt=true; break;


                case 10: failedHunt=false; nameofAnimal="Bat\nEating this animal recovered You 15HP and 10 Water"; playerHP=playerHP+15; playerWater=playerWater+10;  break;
                case 11:failedHunt=false; nameofAnimal="Mouse\nEating this animal recovered You 5HP and 3 Water"; playerHP=playerHP+5; playerWater=playerWater+3;  break;
                case 12:failedHunt=false; nameofAnimal="Deer\nEating this animal recovered You 50HP and 30 Water"; playerHP=playerHP+50; playerWater=playerWater+30;  break;
                case 13: failedHunt=false; nameofAnimal="Squirel\nEating this animal recovered You 20HP and 10 Water"; playerHP=playerHP+20; playerWater=playerWater+10;  break;
                default:
                    throw new IllegalStateException("Unexpected value: " + randomAnimalKill);
            }
        }

   }
