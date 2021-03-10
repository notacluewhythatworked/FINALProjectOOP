package models;

import java.util.Random;

public class Attack {

    public Random rng = new Random();

    public int getRng(int min, int max) {
        return rng.nextInt(max - min + 1) + min;

    }
}
