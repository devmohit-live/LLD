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

    private int getCellValue(Position position) {
        int r = (position.getX() + ORIGIN_SHIFT_FACTOR) ;
        int c = (position.getY() + ORIGIN_SHIFT_FACTOR) ;
        return r * this.board.getColumns() + c;
    }

    public void movePlayerAcrossTheBoard(Player player, int moveVal){
        Position oldPosition = player.getPosition();
        int oldVal = getCellValue(oldPosition);
        int newVal = moveVal + oldVal;
        if (validateMove(newVal)){
            Position newPosition = new Position(newVal / board.getColumns(), newVal % board.getColumns());
            player.move(newPosition);
        }
    }

    private boolean validateMove(int nextVal){
        return board.getRows() * board.getColumns() >= nextVal;
    }

}
