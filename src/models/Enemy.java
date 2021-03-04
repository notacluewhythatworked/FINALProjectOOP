package models;

public class Enemy extends AttackAndDefences {
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

    public int getDefence() {
        return defense;
    }

    public void setDefence(int defence) {
        this.defense = defense;
    }

    public void spawnChance(){

    }
}
