package models;

import views.View;

public class Enemy extends AttackAndDefenses {
    private int health;
    private int damage;
    private int defense;
    private Map grounds = new Map();
    private View attacka = new View();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void spawnChance(){
        int chance = getRng(1,4);
        if(chance < 4){
            //Enemy does not spawn
            System.out.println("Looks like this room is empty.");
            grounds.commonRoom();

        } else {
            System.out.println("Uh oh. There's an enemy in here.");
            attacka.combat();
            //Enemy spawns
        }

    }
}
