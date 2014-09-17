import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class TrafficCars {
	private Random randomGenerator;
	public static LinkedList<Box> trafficCars;
	private boolean toggle = true;
	private int range = 7;
	private int score = 1;

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
		Box newCar = new Box(randomGenerator.nextInt(33), -3);
		if (randomGenerator.nextInt(range) == 1) {
			trafficCars.add(newCar);
		}
		for (Box box : trafficCars) {
			box.y += 1;
			if (box.y == 4) {
				score += 5;
			}
			if (score % 50 == 0) {
				range--;
			}
			if (Game.car.car.x == box.x && Game.car.car.y - 1 == box.y) {
				Game.gameRunning = false;
			}
		}
	}
}