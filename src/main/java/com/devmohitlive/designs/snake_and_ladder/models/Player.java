package com.devmohitlive.designs.snake_and_ladder.models;

public class Player {
    private int id;
    private String name;
    private String color;
    private Position position;

    public Player(int id, String name, String color, Position position) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public void move(Position newPosition) {
        System.out.println("Moving " + name + " at " + newPosition);
        this.position = newPosition;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
