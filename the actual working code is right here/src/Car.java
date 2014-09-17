import java.awt.Color;
import java.awt.Graphics;

public class Car {
	public Box car;

	private int MovementX, movementY;

	public Car() {
		car = new Box(10, 14);
		MovementX = 0;
		movementY = 0;
	}

	public void drawCar(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(car.x * Box.CAR_WIDTH, car.y * Box.CAR_HEIGHT,
				Box.CAR_WIDTH, Box.CAR_HEIGHT);
	}

	public void tick() {
		if (car.x == 0) {
			if (MovementX > 0) {
				car = new Box(car.x + MovementX, car.y + movementY);
			} else {
				car = new Box(car.x = 0, car.y + movementY);
			}
		} else if (car.x == 19) {
			if (MovementX < 0) {
				car = new Box(car.x + MovementX, car.y + movementY);
			} else {
				car = new Box(car.x = 19, car.y + movementY);
			}

		} else {
			car = new Box(car.x + MovementX, car.y + movementY);
		}
		Game.car.setMovementX(0);
		Game.car.setMovementY(0);
	}

	public int getMovementX() {
		return MovementX;
	}

	public void setMovementX(int velX) {
		this.MovementX = velX;
	}

	public int getMovementY() {
		return movementY;
	}

	public void setMovementY(int velY) {
		this.movementY = velY;
	}
}