package com.devmohitlive.designs.snake_and_ladder.models;

import java.util.Random;

public class Dice {
    private int faceValue;
    private int sides;
    Random random;

    public Dice(int sides) {
        this.sides = sides;
        random = new Random();
    }

    public int roll() {
        faceValue = random.nextInt(sides+1)+1;
        System.out.println("Rolling Dice : "+ faceValue);
        return faceValue;
    }

    public int getFaceValue() {
        return faceValue;
    }
}
