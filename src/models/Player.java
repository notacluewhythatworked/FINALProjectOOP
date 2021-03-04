package models;

public class Player extends AttackAndDefences{
    private int healthPoints;
    private int attack;
    private int defence;




    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }



    public void setAttack(int attack) {
        getRng(1,20);
        this.attack = attack;
    }

//    public int getDefence() {
//        return defence;
//    }

    public void setDefence(int defence) {
        getRng(1,20);
        this.defence = defence;
    }

}
