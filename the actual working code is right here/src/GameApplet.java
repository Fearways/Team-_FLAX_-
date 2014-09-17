import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class GameApplet extends Applet {
	private Game game;
	Input iHandler;
	Image car = Toolkit.getDefaultToolkit().createImage("res/car.png");

	public void init() {
		game = new Game();
		game.setBackground(Color.lightGray);
		game.setPreferredSize(new Dimension(500, 600));
		game.setVisible(true);
		game.setFocusable(true);
		this.add(game);
		this.setVisible(true);
		iHandler = new Input(game);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		this.setSize(new Dimension(550, 650));
	}
}