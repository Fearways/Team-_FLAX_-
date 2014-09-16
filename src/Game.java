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
	public static Obstacle obstalce;

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
		obstalce = new Obstacle();
	}

	public void run() {
		while (gameRunning) {
			car.tick();
			render(globalGraphics);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void render(Graphics g) {

//		int lqvaMarkirovka = 10;
//		for (int i = 0; i < 15; i++, lqvaMarkirovka+=30) {
//		g.setColor(Color.white);
//		g.fillRect(65, lqvaMarkirovka, 5, 20);
//		} //STATICHNA za sega
//		int dqsnaMarkirovka = 10;
//		for (int i = 0; i < 15; i++, dqsnaMarkirovka+=30) {
//		g.setColor(Color.white);
//		g.fillRect(130, dqsnaMarkirovka, 5, 20);
//		}
		g.clearRect(0, 0, WIDTH, HEIGHT);
		car.drawCar(globalGraphics);
		obstalce.drawObstacle(g);
	}
}