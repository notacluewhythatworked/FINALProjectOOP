package models;

import views.View;

public class Enemy extends AttackAndDefenses {
    private int health;
    private int damage;
    private int defense;



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
        View attacka = new View();
        Map grounds = new Map();
        int chance = getRng(1,4);
        if(chance < 3){
            //Enemy does not spawn
            System.out.println("Looks like this room is empty.");
            grounds.commonRoom();
        } else {
            //Enemy spawns
            attacka.combat();
        }

    }
}
