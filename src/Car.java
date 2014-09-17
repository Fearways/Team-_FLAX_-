import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Car extends TrafficCar{
	public Box car;

	private int MovementX, movementY;
	private int x,y; 
	private int width;
    private int height;
	
	public Car() {
		car = new Box(10, 10);
		
		MovementX = 0;
		movementY = 0;
		
		x = 10;
		y = 10;
		width = Box.CAR_WIDTH;
        	height = Box.CAR_WIDTH;
        
	}

	public void drawCar(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(car.x * Box.CAR_WIDTH, car.y * Box.CAR_HEIGHT,
				Box.CAR_WIDTH, Box.CAR_HEIGHT);
		g.setColor(Color.WHITE);
		g.drawRect(car.x * Box.CAR_WIDTH, car.y * Box.CAR_HEIGHT,
				Box.CAR_WIDTH, Box.CAR_HEIGHT);
	}

	public void tick() {
		if (car.x == 0) {
			if (MovementX > 0) {
				car = new Box(car.x + MovementX, car.y + movementY);
			} else {
				car = new Box(car.x = 0, car.y + movementY);
			}
		} else if (car.x == 13) {
			if (MovementX < 0) {
				car = new Box(car.x + MovementX, car.y + movementY);
			} else {
				car = new Box(car.x = 13, car.y + movementY);
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
	
	public Rectangle getBounds() {
	    return new Rectangle(x, y, width, height);
	}
	
	public void checkCollisions() {
		
		for( int i = 0; i < TrafficCar.getTrafficCar().size(); i++) {
			Box m = TrafficCar.getTrafficCar().get(i);
			
			if (car.getBounds().intersects(m.getBounds())) {
				System.exit(0);
				
			}
		}
        /*Rectangle r3 = car.getBounds();

        for (int j = 0; j < trafficCars.size(); j++) {
            Box r2 = trafficCars.element();

            if (r3.intersects(r2.getBounds())) {
                System.exit(0);
            	
            }
        }*/
    }
}
