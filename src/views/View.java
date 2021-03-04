package views;

import lib.ConsoleIO;
import models.Items;
import models.Player;

public class View {
    public Player hero = new Player();
    public Items bag = new Items();

    private void mainMenu(){
        //Create menu here
    }

    public void setDifficulty(){
        //Create menu for difficulty here
        //This should be the first menu to show up
        System.out.println("Before we start what type of challenge are you looking for\n");
        int difficult = ConsoleIO.promptForMenuSelection(new String[]{"Easy","Medium","Hard"},true);
        switch(difficult){
            case 1:
                //increase enemy damage
                mainMenu();
                break;
            case 2:
                //increase enemy damage
                mainMenu();
                break;
            case 3:
                //increase enemy damage
                mainMenu();
                break;
        }
    }

    private void movement(){

    }

    private void combat(){
        System.out.println("enemy detected do you want to\n");
        int selection = ConsoleIO.promptForMenuSelection(new String[]{"attack","check/use item","flee"},true);
        switch(selection){
            case 1:
                //Set player attack
                break;
            case 2:
                bag.healthItems();
                break;
            case 3:
                movement();
                break;

        }
    }
}
