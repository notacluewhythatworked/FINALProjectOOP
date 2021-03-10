package models;

public class Player extends Attack {
    private int healthPoints;
    private int attack;

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttack() {

        return attack;
    }


}
