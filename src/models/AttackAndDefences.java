package models;

import java.util.Random;

public class AttackAndDefences {

    public Random rng = new Random();

public int getRng(int min, int max){
    int randNum = rng.nextInt(max-min+1)+ min;
    return randNum;

}
}