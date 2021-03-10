package models;

import views.View;

public class Enemy extends AttackAndDefenses {
    private int health;
    private int damage;
    private int attack;



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

//    public int getDefense() {
//        return defense;
//    }
//
//    public void setDefense(int defense) {
//        this.defense = defense;
//    }


    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int spawnChance(){
        int chance = getRng(1,4);
        if(chance <= 3){
            //Enemy does not spawn
            return 0;
        } else {
            //Enemy spawns
            return 1;
        }

    }
}
