package com.devmohitlive.designs.snake_and_ladder.models;

import java.util.List;

import static java.lang.Thread.sleep;

public class Game {
    private BoardManager boardManager;
    private Dice dice;
    private List<Player> players;
    private List<IGameEntity> snakeLadders;
    private int currentPlayerIndex;

    public Game(BoardManager boardManager, Dice dice, List<Player> players, List<IGameEntity> snakeLadders) {
        this.boardManager = boardManager;
        this.dice = dice;
        this.players = players;
        this.snakeLadders = snakeLadders;
    }

    public Player start() {
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            movePlayer(currentPlayer);
            if(currentPlayer.getPosition().equals(boardManager.getEnd())){
                return currentPlayer;
            }
            currentPlayerIndex = (currentPlayerIndex+1)%players.size();
        }
    }

    private void movePlayer(Player player){
        System.out.println("Player "+ player+" is going to roll the dice");
        int netVal = getValidDiceMove();
        boardManager.movePlayerAcrossTheBoard(player,netVal);
        for(IGameEntity snakeLadder : snakeLadders){
            snakeLadder.apply(player);
        }
        try {
            sleep(1000);
        } catch (InterruptedException e) {

        }
    }

    private int getValidDiceMove(){
        int val = dice.roll();
        int count = 1;
        int netVal = val;
        while(val == 6){
            if(count == 3) return 0;
            val = dice.roll();
            count++;
            netVal+=val;
        }
        return netVal;
    }

}
