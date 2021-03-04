package models;

public class Enemy extends AttackAndDefences {
    private int health;
    private int damage;
    private int defence;

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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
    //wow, I made some changes
    public void spawnChance(){

    }
}
