package com.devmohitlive.designs.snake_and_ladder.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int rows;
    private int columns;
    private List<Position> cells;



    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }


    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.cells = new ArrayList<>(this.rows * this.columns);
        initBoard();
    }
    private void initBoard() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.cells.add(new Position(i, j));
            }
        }
    }

}
