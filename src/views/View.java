package views;

import enums.Direction;
import lib.ConsoleIO;
import models.Enemy;
import models.Items;
import models.Map;
import models.Player;

public class View {
    public Player hero = new Player();
    public Items bag = new Items();
    public Enemy enemy = new Enemy();
    public Map map = new Map();
//    public int pointer = ConsoleIO.promptForMenuSelection(new String[]{"North", "South", "East", "West"}, false);
    private int difficult = 1;
    private int drinks = 1;

    public void mainMenu(){
        setDifficulty();
        map.startup();
        System.out.println("\nWelcome to your doom.");
        System.out.println("Which way would you like to move?\n");
        loopRoom();
        checkRoom();


    }

    public void checkRoom(){

        switch(map.currentRoom.getName()) {
            case "Healing Fountain":
                healingFountain();
                break;
            case "Miniboss Room":
                //make miniboss
                commonRoom();
                break;
            case "Boss Room":
                //Make boss
                bossRoom();
                break;
            default:
                movement();
                commonRoom();
                break;
        }

    }
    public Boolean promptThenMove(){
        switch (ConsoleIO.promptForMenuSelection(new String[]{"North", "South", "East", "West"}, false)){
            case 1:
                return map.goDirection(Direction.NORTH);
            case 2:
                return map.goDirection(Direction.SOUTH);
            case 3:
                return map.goDirection(Direction.EAST);
            case 4:
                return map.goDirection(Direction.WEST);
            default:
                return null;
        }
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
                drinks =3;
                break;
            case 2:
                //medium
                enemy.setDamage(50);
                enemy.setHealth(75); //PLACEHOLDER VALUE
                enemy.setDefense(50); //PLACEHOLDER VALUE
                hero.setAttack(25); //PLACEHOLDER VALUE
                drinks =2;
                break;
            case 3:
                //hard
                enemy.setDamage(75);
                enemy.setHealth(100); //PLACEHOLDER VALUE
                enemy.setDefense(75); //PLACEHOLDER VALUE
                hero.setAttack(30); //PLACEHOLDER VALUE
                drinks =1;
                break;
        }
    }

    public void bossRoom(){
        System.out.println("This is the boss room. Are you sure you're ready for this?");
        int fin;
        fin = ConsoleIO.promptForMenuSelection(new String[]{"Yes", "No"}, false);
        switch (fin){
            case 1:
                //fight boss
                break;
            case 2:
                //stay in previous room
                break;
        }

    }

    private void movement() {
//        map.updateOutput();
        switch (enemy.spawnChance()) {
            case 0:
                System.out.println("Looks like this room is empty.");
                commonRoom();
                break;
            case 1:
                combat();
                break;
        }
    }

        public void commonRoom(){
            System.out.println("You enter a common room");
            loopRoom();
            checkRoom();

        }

    public void healingFountain(){
        //moveTo(put info in here);
        if (drinks!= 0){
            hero.setHealthPoints(100);
            drinks--;
            System.out.println("Your health has been restored. You are at " + hero.getHealthPoints() + " health.");
        } else {
            System.out.println("Unfortunately, you've used the healing fountain too many times. Your health is currently at " + hero.getHealthPoints() + ". Good luck out there.");
        }
        loopRoom();
        checkRoom();

    }

    public void combat(){
        System.out.println("Enemy detected. What would you like to do?\n");
        int selection = ConsoleIO.promptForMenuSelection(new String[]{"Attack","Use Item","Flee"},false);
        switch(selection){
            case 1:
                System.out.println("you prepare to attack");
                break;
            case 2:
                bag.healthItems();
                break;
            case 3:
                System.out.println("Oof. That attack was stronger than expected and you died.");
                mainMenu();
                break;

        }
    }
    public void loopRoom(){
        boolean meh;
        Boolean burger;
        do{
            burger = promptThenMove();
            if(burger == null){
                System.out.println("no");
                meh = false;
            }else{
                if (burger) {
                    meh = false;
                }else{
                    meh = true;
                }
            }
        }while(!meh);
    }
}
