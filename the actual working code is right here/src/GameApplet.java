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