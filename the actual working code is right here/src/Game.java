import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

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
			render(globalGraphics);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		drawScore(globalGraphics);
	}

	public void render(Graphics g) {
		g.clearRect(0, 0, WIDTH, HEIGHT);
		car.drawCar(globalGraphics);
		trafficCar.drawTrafficCar(g);
		drawLevel(trafficCar.level, globalGraphics);
	}

	private void drawScore(Graphics g) {
		g.setColor(Color.white);
		g.drawString("Your score: " + (trafficCar.score - 1), WIDTH / 2 - 50,
				HEIGHT / 2);
	}

	private void drawLevel(int level, Graphics g) {
		g.setColor(Color.white);
		g.drawString("Level: " + level, 6, 10);
	}
}