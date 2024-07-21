package com.devmohitlive.designs.snake_and_ladder;

import com.devmohitlive.designs.snake_and_ladder.models.*;

import java.util.List;

public class GameManager {

    public void startGame(){
        //Board
        Board board = new Board(10,10);

        //Board Manager
        Position start = new Position(0,0);
        Position end = new Position(board.getRows()-1,board.getColumns()-1);
        System.out.println("End Grid is "+end);
        BoardManager boardManager = new BoardManager(board,start,end);

        // Dice
        Dice dice = new Dice(6);

        // Players
        Player player1 = new Player(1,"Mohit","Green", boardManager.getStart());
        Player player2 = new Player(2,"Shobhit","Blue", boardManager.getStart());
        List<Player> players = List.of(player1,player2);

        // Snake and Ladders
        IGameEntity snake1 = new Snake(new Position(2,8),new Position(0,8));
        IGameEntity snake2 = new Snake(new Position(3,2),new Position(1,4));
        IGameEntity snake3 = new Snake(new Position(3,6),new Position(0,4));
        IGameEntity snake4 = new Snake(new Position(5,8),new Position(2,8));
        IGameEntity snake5 = new Snake(new Position(5,1),new Position(2,6));
        IGameEntity snake6 = new Snake(new Position(7,5),new Position(4,6));
        IGameEntity ladder1 = new Ladder(new Position(0,1),new Position(2,4));
        IGameEntity ladder2 = new Ladder(new Position(1,0),new Position(6,4));
        IGameEntity ladder3 = new Ladder(new Position(2,8),new Position(5,7));
        IGameEntity ladder4 = new Ladder(new Position(4,0),new Position(6,1));
        List<IGameEntity> IGameEntityList = List.of(snake1,snake2, snake3, snake4, snake5, snake6, ladder1, ladder2, ladder3, ladder4);

        Game game = new Game(boardManager,dice,players,IGameEntityList);
        Player winner = game.start();
        System.out.println("Winner is "+winner);
    }


}
