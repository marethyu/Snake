package com.snake.gameRunner;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.snake.supportClasses.Board;
import com.snake.supportClasses.Cell;
import com.snake.supportClasses.Router;
import com.snake.supportClasses.Snake;

public class GamePanel extends JPanel implements ActionListener {
	public static final long serialVersionUID = 0xFFL;
	
	private final int pxSize = 10;
	private final int rowCount = 40;
	private final int colCount = 30;
	
	private Board mainBoard;
	private Cell startingCell;
	public Router controller;
	private Snake snake;
	
	private Timer animator;
	
	public GamePanel() {
		initComponents();
	}
	
	public void paint(Graphics g) {
		for (int i = 0; i < mainBoard.ROW_COUNT; i++) {
			for (int j = 0; j < mainBoard.COL_COUNT; j++) {
				if (mainBoard.cells[i][j].type == Cell.CELL_TYPE_EMPTY) g.setColor(new Color(0x000000));
                if (mainBoard.cells[i][j].type == Cell.CELL_TYPE_FOOD) g.setColor(new Color(0xFF0000));
                
                g.fillRect(j*pxSize, i*pxSize, pxSize, pxSize);
			}
		}
		
		for (int i = 0; i < snake.snakePartList.size(); i++) {
			int row = snake.snakePartList.get(i).row;
			int col = snake.snakePartList.get(i).col;
			
			g.setColor(new Color(0x00FF00));
            g.fillRect(col*pxSize, row*pxSize, pxSize, pxSize);
		}
	}
	
	private void initComponents() {
		mainBoard = new Board(rowCount, colCount);
		startingCell = new Cell(20, 20);
		snake = new Snake(startingCell);
		controller = new Router(snake, mainBoard);
		animator = new Timer(100, this);
		controller.setDirection(Router.DIRECTION_NONE);
		mainBoard.generateFood();
		animator.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (controller.gameOver) {
			animator.stop();
			
			if (JOptionPane.showConfirmDialog(this, "Play again?", "Game over!", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
				initComponents();
			else
				System.exit(0);
		} else {
			controller.update();
			repaint();
		}
	}
}
