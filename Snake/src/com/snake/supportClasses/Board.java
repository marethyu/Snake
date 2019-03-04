package com.snake.supportClasses;

public class Board {
    public final int ROW_COUNT, COL_COUNT;
    public Cell[][] cells;
    
    public Board(int rowCount, int columnCount) {
        ROW_COUNT = rowCount;
        COL_COUNT = columnCount;
        cells = new Cell[ROW_COUNT][COL_COUNT];
        
        for (int row = 0; row < ROW_COUNT; row++) {
            for (int column = 0; column < COL_COUNT; column++) {
                cells[row][column] = new Cell(row, column);
            }
        }
    }
    
    public void generateFood() {
        int row = new java.util.Random().nextInt(ROW_COUNT - 1);
        int col = new java.util.Random().nextInt(COL_COUNT - 1);
        
        cells[row][col].type = Cell.CELL_TYPE_FOOD;
    }
}