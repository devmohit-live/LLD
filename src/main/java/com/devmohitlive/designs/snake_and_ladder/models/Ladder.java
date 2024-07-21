package com.devmohitlive.designs.snake_and_ladder.models;

public class Ladder implements IGameEntity {
    Position start;
    Position end;
    public Ladder(Position start, Position end) {
        this.start = start;
        this.end = end;
    }
    public void apply(Player player){
        if(player.getPosition().equals(start)){
            System.out.println("--------- Player "+player+" took ladder ---------");
            player.move(end);
        }
    }
}
