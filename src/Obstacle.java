import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Obstacle {
	private Random randomGenerator;
	private Box obstacleBox;

	public Obstacle() {
		obstacleBox = createObstacle(Game.car);
	}

	private Box createObstacle(Car c) {
		randomGenerator = new Random();

		int x = randomGenerator.nextInt(Game.COLS);
		int y = randomGenerator.nextInt(1);

		Box b = new Box(x, y);
		
		return b;
	}
	

	public void drawObstacle(Graphics g) {
		int boxSize = obstacleBox.OBSTACLE_SIZE;
		g.setColor(Color.green);
		g.fillRect(obstacleBox.x * boxSize, obstacleBox.y * boxSize, boxSize,
				boxSize);
	}
}
