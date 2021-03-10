package views;

import enums.Direction;
import lib.ConsoleIO;
import models.*;

public class View {
    public Player hero = new Player();
    public Items bag = new Items();
    public Enemy enemy = new Enemy();
    public Map map = new Map();
    public Enemy bigBad = new Enemy();
    public Enemy dragon = new Enemy();
    private Attack attack = new Attack();
    private int difficult = 1;
    private int drinks = 1;

    public void mainMenu() {
        setDifficulty();
        map.startup();
        System.out.println("\nWelcome to your doom.");
        System.out.println("Which way would you like to move?\n");
        loopRoom();
        checkRoom();


    }

    public void checkRoom() {
        switch (map.currentRoom.getName()) {
            case "Healing Fountain":
                healingFountain();
                break;
            case "Miniboss Room":
                dragonKeep();
                break;
            case "Boss Room":
                bossRoom();
                break;
            default:
                movement();
                commonRoom();
                break;
        }

    }

    public Boolean promptThenMove() {
        switch (ConsoleIO.promptForMenuSelection(new String[]{"North", "South", "East", "West"}, false)) {
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

    private void setDifficulty() {
        System.out.println("Before we start, what type of challenge are you looking for?\n");
        difficult = ConsoleIO.promptForMenuSelection(new String[]{"Easy", "Medium", "Hard"}, false);
        hero.setHealthPoints(100);
        bigBad.setHealth(150);
        dragon.setHealth(100);
        enemy.setHealth(50);
        hero.setAttack(20);
        switch (difficult) {
            case 1:
                //easy
                enemy.setAttack(10);
                dragon.setAttack(15);
                bigBad.setAttack(20);
                drinks = 3;
                break;
            case 2:
                //medium
                enemy.setAttack(15);
                dragon.setAttack(20);
                bigBad.setAttack(25);
                drinks = 2;
                break;
            case 3:
                //hard
                enemy.setAttack(20);
                dragon.setAttack(23);
                bigBad.setAttack(28);
                drinks = 1;
                break;
        }
    }

    public void bossRoom() {
        System.out.println("This is the boss room. Are you sure you're ready for this?");
        int fin;
        fin = ConsoleIO.promptForMenuSelection(new String[]{"Yes", "No"}, false);
        switch (fin) {
            case 1:
                bossFight();
                break;
            case 2:
                loopRoom();
                checkRoom();
                break;
        }
    }

    public void miniboss() {
        System.out.println("Enemy detected. What would you like to do?\n");
        int selection = ConsoleIO.promptForMenuSelection(new String[]{"Attack", "attempt to flee"}, false);
        System.out.println("Enemy health:" + dragon.getHealth());
        System.out.println("Hero health: " + hero.getHealthPoints());
        switch (selection) {
            case 1:
                System.out.println("you roll to seduce the dragon");
                dragon.setHealth(dragon.getHealth() - hero.attack());
                hero.setHealthPoints(hero.getHealthPoints() - dragon.attack());
                System.out.println(dragon.getHealth());
                System.out.println(hero.getHealthPoints());
                if (hero.getHealthPoints() <= 0) {
                    System.out.println("\nSnake...Snake!.!SNAAAAAAKE!!!");
                    mainMenu();
                }
                break;
            case 2:
                System.out.println("Oof. That attack was stronger than expected and you died.\n");
                mainMenu();
                break;
        }
        if (dragon.getHealth() <= 0) {
            System.out.println("gg no re");
            hero.setHealthPoints(hero.getHealthPoints() + 20);
            dragon.setHealth(100);
        } else {
            combat();
        }
    }

    public void dragonKeep() {
        System.out.println("The dragon looms above you");
        miniboss();
    }

    private void movement() {
        switch (enemy.spawnChance()) {
            case 0:
//                System.out.println("Looks like this room is empty.");
                commonRoom();
                break;
            case 1:
                combat();
                break;
        }
    }

    public void commonRoom() {
        System.out.println("You enter " + map.currentRoom.getName());
        loopRoom();
        checkRoom();
    }

    public void healingFountain() {
        if (drinks != 0) {
            hero.setHealthPoints(100);
            drinks--;
            System.out.println("Your health has been restored. You are at " + hero.getHealthPoints() + " health.");
        } else {
            System.out.println("Unfortunately, you've used the healing fountain too many times. Your health is currently at " + hero.getHealthPoints() + ". Good luck out there.");
        }
        loopRoom();
        checkRoom();
    }

    public void combat() {
        System.out.println("Enemy detected. What would you like to do?\n");
        int selection = ConsoleIO.promptForMenuSelection(new String[]{"Attack", "Flee aka enemy's will keel"}, false);
        System.out.println("Enemy Health: " + enemy.getHealth());
        System.out.println("Hero Health: " + hero.getHealthPoints());
        switch (selection) {
            case 1:
                System.out.println("\nYou prepare to attack...\n");
                enemy.setHealth(enemy.getHealth() - hero.attack());
                hero.setHealthPoints(hero.getHealthPoints() - enemy.attack());
                System.out.println("Enemy Health: " + enemy.getHealth());
                System.out.println("Player Health: " + hero.getHealthPoints());
                if (hero.getHealthPoints() <= 0) {
                    System.out.println("Snake...Snake!.!SNAAAAAAKE!!!");
                    replayOption();
                }
                break;
            case 2:
                System.out.println("Oof. That attack was stronger than expected and you died.");
                replayOption();
                break;
        }
        if (enemy.getHealth() <= 0) {
            System.out.println("\nNice job! You defeated your enemy. gg no re\n");
            hero.setHealthPoints(hero.getHealthPoints() + 20);
            enemy.setHealth(50);
        } else {
            combat();
        }
    }

    public void bossFight() {
        System.out.println("This is it. Make them PAY");
        int braveChoice = ConsoleIO.promptForMenuSelection(new String[]{"Attack", "Perish from existence"}, false);
        System.out.println("Boss health:" + bigBad.getHealth());
        System.out.println("Player health: " + hero.getHealthPoints());
        switch (braveChoice) {
            case 1:
                System.out.println("You pull your sword out with a loud 'shwing'");
                bigBad.setHealth(bigBad.getHealth() - hero.attack());
                hero.setHealthPoints(hero.getHealthPoints() - bigBad.attack());
                System.out.println("boss health: " + bigBad.getHealth());
                System.out.println("hero health: " + hero.getHealthPoints());
                if (hero.getHealthPoints() <= 0) {
                    System.out.println("K.O.");
                    mainMenu();
                }
                break;
            case 2:
                System.out.println("You try to flee but bigBad pummels you to death... oof");
                break;
        }
        if (bigBad.getHealth() <= 0) {
            System.out.println("You have freed the innocent souls from this dungeon. I'm proud of you son\n");
            System.out.println("Thanks so much for playing our game");
            mainMenu();
        } else {
            bossFight();
        }
    }

    public void loopRoom() {
        boolean meh;
        Boolean burger;
        do {
            burger = promptThenMove();
            if (burger == null) {
                System.out.println("no");
                meh = false;
            } else {
                if (burger) {
                    meh = false;
                } else {
                    meh = true;
                }
            }
        } while (!meh);
    }

    public void replayOption(){
        System.out.println("Unfortunately, you died in that last encounter. Would you like to retry?\n");
        int selection = ConsoleIO.promptForMenuSelection(new String[]{"Yes"}, true);
        switch(selection){
            case 1:
                mainMenu();
                break;
            default:
                break;
        }
    }
}
