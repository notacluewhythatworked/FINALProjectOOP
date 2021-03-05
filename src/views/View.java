package views;

import lib.ConsoleIO;
import models.Enemy;
import models.Items;
import models.Player;

public class View {
    public Player hero = new Player();
    public Items bag = new Items();
    public Enemy enemy = new Enemy();

    public void mainMenu(){
        setDifficulty();
        movement();
    }

    private void setDifficulty(){
        //Create menu for difficulty here
        //This should be the first menu to show up
        System.out.println("Before we start, what type of challenge are you looking for\n");
        int difficult = ConsoleIO.promptForMenuSelection(new String[]{"Easy","Medium","Hard"},true);
        switch(difficult){
            case 1:
                enemy.setDamage(25);
                enemy.setHealth(30); //PLACEHOLDER VALUE
                enemy.setDefense(25); //PLACEHOLDER VALUE
                break;
            case 2:
                enemy.setDamage(50);
                enemy.setHealth(40); //PLACEHOLDER VALUE
                enemy.setDefense(50); //PLACEHOLDER VALUE
                break;
            case 3:
                enemy.setDamage(75);
                enemy.setHealth(50); //PLACEHOLDER VALUE
                enemy.setDefense(75); //PLACEHOLDER VALUE
                break;
        }
    }

    private void movement(){
        //inform the player where they are currently and prompt them with possible moves.
    }

    private void combat(){
        System.out.println("enemy detected do you want to\n");
        int selection = ConsoleIO.promptForMenuSelection(new String[]{"attack","check/use item","flee"},true);
        switch(selection){
            case 1:
                //Set player attack
                movement();
                break;
            case 2:
                bag.healthItems();
                movement();
                break;
            case 3:
                System.out.println("Oof. That attack was stronger than expected and you died.");
                mainMenu();
                break;

        }
    }
}
