package models;

public class Player extends AttackAndDefenses {
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
