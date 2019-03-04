package com.snake.supportClasses;

public class Cell {
    public final static int CELL_TYPE_EMPTY = 0;
	public final static int CELL_TYPE_FOOD = 10;
	
    public final int row, col;
    public int type;
    
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}