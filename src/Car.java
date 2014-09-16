import java.awt.Color;
import java.awt.Graphics;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Car {
	public Box car;

	private int VelX, VelY;

	public Car() {
		car = new Box(10, 16);

		VelX = 0;
		VelY = 0;
	}

	public void drawCar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(car.x * Box.CAR_WIDTH, car.y * Box.CAR_HEIGHT,
				Box.CAR_WIDTH, Box.CAR_HEIGHT);
	}

	public void tick() {
		if (car.x == 0) {
			if (VelX > 0) {
				car = new Box(car.x + VelX, car.y + VelY);
			} else {
				car = new Box(car.x = 0, car.y + VelY);
			}
		} else if (car.x == 19) {
			if (VelX < 0) {
				car = new Box(car.x + VelX, car.y + VelY);
			} else {
				car = new Box(car.x = 19, car.y + VelY);
			}

		} else {
			car = new Box(car.x + VelX, car.y + VelY);
		}
	}

	public int getVelX() {
		return VelX;
	}

	public void setVelX(int velX) {
		this.VelX = velX;
	}

	public int getVelY() {
		return VelY;
	}

	public void setVelY(int velY) {
		this.VelY = velY;
	}
}
