package com.devmohitlive.designs.snake_and_ladder.models;

public class Position {
    private long id;
    private int x;
    private int y;

    public Position(long id) {
       this.id = id;
    }
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Val "+ id+" "+
                "Grid Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.x == other.getX() && this.y == other.getY() && this.id == other.getId();
    }
}
