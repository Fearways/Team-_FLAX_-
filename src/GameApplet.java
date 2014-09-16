import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class GameApplet extends Applet {
	private Game game;
	Input iHandler;

	public void init() {
		game = new Game();
		game.setBackground(Color.lightGray);
		game.setPreferredSize(new Dimension(game.WIDTH, game.HEIGHT));
		game.setVisible(true);
		game.setFocusable(true);
		this.add(game);
		this.setVisible(true);
		iHandler = new Input(game);
	}

	
	public void paint(Graphics g) {
		this.setSize(new Dimension(800, 650));
	}
}