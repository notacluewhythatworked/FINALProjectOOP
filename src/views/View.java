package views;

import lib.ConsoleIO;
import models.Enemy;
import models.Items;
import models.Map;
import models.Player;
import movement.PlayerMovement;

public class View {
    public Player hero = new Player();
    public Items bag = new Items();
    public Enemy enemy = new Enemy();
    public Map map = new Map();
    private int difficult = 1;

    public void mainMenu(){
        setDifficulty();
        map.startingRoom();
        movement();
    }

    private void setDifficulty(){
        System.out.println("Before we start, what type of challenge are you looking for?\n");
        difficult = ConsoleIO.promptForMenuSelection(new String[]{"Easy","Medium","Hard"},true);
        hero.setHealthPoints(100);
        switch(difficult){
            case 1:
                //easy
                enemy.setDamage(25);
                enemy.setHealth(50); //PLACEHOLDER VALUE
                enemy.setDefense(25); //PLACEHOLDER VALUE
                hero.setAttack(20); //PLACEHOLDER VALUE
                map.healingFountain(1);
                break;
            case 2:
                //medium
                enemy.setDamage(50);
                enemy.setHealth(75); //PLACEHOLDER VALUE
                enemy.setDefense(50); //PLACEHOLDER VALUE
                hero.setAttack(25); //PLACEHOLDER VALUE
                map.healingFountain(2);
                break;
            case 3:
                //hard
                enemy.setDamage(75);
                enemy.setHealth(100); //PLACEHOLDER VALUE
                enemy.setDefense(75); //PLACEHOLDER VALUE
                hero.setAttack(30); //PLACEHOLDER VALUE
                map.healingFountain(3);
                break;
        }
    }

    private void movement(){
//        map.updateOutput();
        enemy.spawnChance();
    }

    public void combat(){
        System.out.println("Enemy detected. What would you like to do?\n");
        int selection = ConsoleIO.promptForMenuSelection(new String[]{"Attack","Use Item","Flee"},false);
        switch(selection){
            case 1:
                hero.setAttack(difficult);
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
