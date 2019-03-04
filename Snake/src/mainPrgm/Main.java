/***************************************************************
 * 
 *                         Snake JAVA
 *                         By Jimmy Y.
 *                       On Aug. 5, 2018
 * 
 * 
 ***************************************************************/

package mainPrgm;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import com.snake.gameRunner.GamePanel;
import com.snake.supportClasses.Router;

public class Main extends JFrame implements KeyListener {
	private static final long serialVersionUID = 0xFFL;
	
	private GamePanel panel = new GamePanel();
	
	public Main() {
		super("Snake JAVA");
		setSize(316, 440);
		setLocationRelativeTo(null);
		setContentPane(panel);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		addKeyListener(this);
		setResizable(false);
		setVisible(true);
	}
	
	public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) panel.controller.setDirection(Router.DIRECTION_RIGHT);
        if (e.getKeyCode() == KeyEvent.VK_LEFT) panel.controller.setDirection(Router.DIRECTION_LEFT);
		if (e.getKeyCode() == KeyEvent.VK_UP) panel.controller.setDirection(Router.DIRECTION_UP);
        if (e.getKeyCode() == KeyEvent.VK_DOWN) panel.controller.setDirection(Router.DIRECTION_DOWN);
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	public static void main(String... args) {
		SwingUtilities.invokeLater(() -> {new Main();});
	}
}
