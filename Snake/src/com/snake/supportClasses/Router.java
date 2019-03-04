package com.snake.supportClasses;

public class Router {
    public static final int DIRECTION_NONE = 0;
	public static final int DIRECTION_RIGHT = 1;
	public static final int DIRECTION_LEFT = -1;
	public static final int DIRECTION_UP = 2;
	public static final int DIRECTION_DOWN = -2;
	
	private final int leftWall = -1;
	private final int topWall = -1;
	private final int rightWall;
	private final int bottomWall;
	
    private Snake snake;
    private Board board;
    private int direction;
    public boolean gameOver = false;
    
    public Router(Snake snake, Board board) {
        this.snake = snake;
        this.board = board;
        rightWall = board.COL_COUNT;
        bottomWall = board.ROW_COUNT;
    }
    
    public void setDirection(int direction) {
        this.direction = direction;
    }
    
    public void update() {
        if (!gameOver && direction != DIRECTION_NONE) {
        	Cell nextCell = getNextCell(snake.head);
        	
            if (snake.checkCrash(nextCell)) {
                setDirection(DIRECTION_NONE);
                gameOver = true;
            } else {
                snake.move(nextCell);
                
                if (nextCell.type == Cell.CELL_TYPE_FOOD) {
                    snake.grow();
                    board.generateFood();
                }
            }
        }
    }
    
    private Cell getNextCell(Cell currentPosition) {
        int row = currentPosition.row;
        int col = currentPosition.col;
        
        if (direction == DIRECTION_RIGHT) col++;
        if (direction == DIRECTION_LEFT) col--;
        if (direction == DIRECTION_UP) row--;
        if (direction == DIRECTION_DOWN) row++;
        
        //Teleport to other side if the snake reaches the wall
        if (row == topWall) row = bottomWall - 1;
        if (row == bottomWall) row = topWall + 1;
        if (col == rightWall) col = leftWall + 1;
        if (col == leftWall) col = rightWall - 1;
        
        return board.cells[row][col];
    }
}