import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Input implements KeyListener {

	public Input(Game game) {
		game.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();

		if (keyCode == KeyEvent.VK_RIGHT) {
			Game.car.setVelX(1);
			Game.car.setVelY(0);
		} else if (keyCode == KeyEvent.VK_LEFT) {
			Game.car.setVelX(-1);
			Game.car.setVelY(0);
		}
		if (keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
