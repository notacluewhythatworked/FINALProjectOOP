package models;

public class Player extends AttackAndDefences{
    private int healthPoints;
    private int attack;
    private int defense;




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

//    public int getDefense() {
//        return defense;
//    }

    public void setDefense(int defense) {
        getRng(1,20);
        this.defense = defense;
    }

}
