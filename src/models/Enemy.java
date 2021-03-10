package models;

import views.View;

public class Enemy extends Attack {
    private int health;

    private int attack;



    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }






    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int spawnChance(){
        int chance = getRng(1,4);
        if(chance < 3){
            //Enemy does not spawn
            return 0;
        } else {
            //Enemy spawns
            return 1;
        }

    }
}
