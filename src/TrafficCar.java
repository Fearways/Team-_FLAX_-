import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class TrafficCar {
	private Random randomGenerator;
	public static LinkedList<Box> trafficCars;

	public TrafficCar() {
		trafficCars = new LinkedList<>();
		Collections.addAll(trafficCars, new Box(1, 0), new Box(7, 0), new Box(
				11, 0), new Box(19, 0));
	}

	public void drawTrafficCar(Graphics g) {
		for (Box box : trafficCars) {
			g.setColor(Color.red);
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
		Box newCar = new Box(randomGenerator.nextInt(33), 0);
		if (randomGenerator.nextInt(7)==1) {
			trafficCars.add(newCar);
		}
		for (Box box : trafficCars) {
			box.y += 1;
		}
	}
}
