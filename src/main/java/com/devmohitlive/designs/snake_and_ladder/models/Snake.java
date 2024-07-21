package com.devmohitlive.designs.snake_and_ladder.models;

public class Snake implements IGameEntity{
    Position start;
    Position end;
    public Snake(Position start, Position end) {
        this.start = start;
        this.end = end;
    }
    public void apply(Player player){
        if(player.getPosition().equals(start)){
            System.out.println("--------- Player "+player+" got bitten by snake ---------");
            player.move(end);
        }

    }
}
