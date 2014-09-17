import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class Game extends Canvas implements Runnable {

	public static final int ROWS = 30;
	public static final int COLS = 25;
	public static final int SIZE = 20;
	public static final int WIDTH = COLS * SIZE;
	public static final int HEIGHT = ROWS * SIZE;

	public static Car car;
	public static TrafficCars trafficCar;

	private Thread runThread;
	private Graphics globalGraphics;

	static boolean gameRunning = false;

	public void paint(Graphics g) {
		globalGraphics = g.create();

		if (runThread == null) {
			runThread = new Thread(this);
			runThread.start();
			gameRunning = true;
		}
	}

	public Game() {
		car = new Car();
		trafficCar = new TrafficCars();
	}

	public void run() {
		while (gameRunning) {
			car.tick();
			trafficCar.trafficUpdate();
			// TrafficCar.trafficUpdate;
			render(globalGraphics);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void render(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		car.drawCar(globalGraphics);
		trafficCar.drawTrafficCar(g);
	}
}