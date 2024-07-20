package com.devmohitlive.designs.snake_and_ladder;

public class Client {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        System.out.println("********* Starting the Game *************");
        gameManager.startGame();
        System.out.println("********* Ending the Game *************");
    }
}
