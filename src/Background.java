package CurrentDateTime;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;

import javax.swing.JPanel;

public class Backgound extends JPanel {
	private int width = 0;
	private int height = 0;
	private Image image = Toolkit.getDefaultToolkit().createImage(
			"res/background.png");
	public Image gameOver = Toolkit.getDefaultToolkit().createImage(
			"res/gameover.png");
	private int x1 = 0;
	private int y1 = 0;
	private boolean init = true;

	public void init(int w, int h) {
		if (init) {
			this.width = w;
			this.height = h;
			init = false;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x1, y1, width + 5, height, null); 
		// add if(Game.gameOver)
		g.drawImage(gameOver, x1, y1, width + 5, height, null);
	}
}