package com.devmohitlive.designs.snake_and_ladder.models;

public class BoardManager {
    private Board board;
    private Position start;
    private Position end;
    private final int ORIGIN_SHIFT_FACTOR = 1;


    public BoardManager(Board board, Position start, Position end) {
        this.board = board;
        this.start = start;
        this.end = end;
        System.out.println("End is "+ getCellValue(end));
    }

    public Position getEnd() {
        return end;
    }

    public Board getBoard() {
        return board;
    }

    public Position getStart() {
        return start;
    }

    private long getCellValue(Position position) {
       return position.getId();
    }

    public void movePlayerAcrossTheBoard(Player player, int moveVal){
        Position oldPosition = player.getPosition();
        long oldVal = getCellValue(oldPosition);
        long newVal = moveVal + oldVal;
        if (validateMove(newVal)){
            Position newPosition = new Position((int)newVal / board.getColumns(), (int)newVal % board.getColumns());
            player.move(newPosition);
            System.out.println("Moved to "+newVal);
        }else{
            System.out.println("No movement for the Player "+player+" Stayed at "+oldVal);
        }
    }

    private boolean validateMove(long nextVal){
        return (long) board.getRows() * board.getColumns() >= nextVal;
    }

}
