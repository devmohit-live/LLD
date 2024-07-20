package com.devmohitlive.designs.snake_and_ladder.models;

public class SnakeLadder {
    Position start;
    Position end;
    public SnakeLadder(Position start, Position end) {
        this.start = start;
        this.end = end;
    }
    public void apply(Player player){
        System.out.println("Applying Snake Ladder to Player "+player);
        player.move(end);
    }
}
