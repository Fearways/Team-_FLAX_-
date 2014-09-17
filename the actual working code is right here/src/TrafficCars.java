import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class TrafficCars {
	private Random randomGenerator;
	public static LinkedList<Box> trafficCars;
	private boolean toggle = true;
	public int score = 1;
	public int level = 1;
	private int range = 7;

	public TrafficCars() {
		trafficCars = new LinkedList<>();
	}

	public void drawTrafficCar(Graphics g) {
		toggle ^= true;
		for (Box box : trafficCars) {
			if (toggle == true) {
				g.setColor(Color.BLUE);
			}
			if (toggle == false) {
				g.setColor(Color.RED);
			}
			g.fillRect(box.x * Box.TRAFFICCAR_WIDTH, box.y
					* Box.TRAFFICCAR_HEIGHT, Box.TRAFFICCAR_WIDTH,
					Box.TRAFFICCAR_HEIGHT);
			g.setColor(Color.black);
			g.drawRect(box.x * Box.TRAFFICCAR_WIDTH, box.y
					* Box.TRAFFICCAR_HEIGHT, Box.TRAFFICCAR_WIDTH,
					Box.TRAFFICCAR_HEIGHT);
		}
	}

	public void trafficUpdate() {
		randomGenerator = new Random();
		Box newCar = new Box(randomGenerator.nextInt(33), -5);
		if (score < 150 & randomGenerator.nextInt(range) == 1) {
			trafficCars.add(newCar);
		} else if (score >= 150
				&& score < 300
				&& (randomGenerator.nextInt(range) == 1 || randomGenerator
						.nextInt(range) == 2)) {
			trafficCars.add(newCar);
			level = 2;
		} else if (score >= 300
				&& score < 600
				&& (randomGenerator.nextInt(range) == 1
						|| randomGenerator.nextInt(range) == 2 || randomGenerator
						.nextInt(range) == 3)) {
			trafficCars.add(newCar);
			level = 3;
		} else if (score >= 600
				&& (randomGenerator.nextInt(range) == 1
						|| randomGenerator.nextInt(range) == 2
						|| randomGenerator.nextInt(range) == 3 || randomGenerator
						.nextInt(range) == 4)) {
			trafficCars.add(newCar);
			level = 4;
		}

		for (Box box : trafficCars) {
			box.y += 1;
			if (box.y == 15) {
				score += 5;
			}
			if (Game.car.car.x == box.x && Game.car.car.y - 1 == box.y) {
				Game.gameRunning = false;
			}
		}
	}
}