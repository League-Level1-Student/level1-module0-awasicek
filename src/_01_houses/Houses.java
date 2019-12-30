package _01_houses;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class Houses {
	Robot homeBot = new Robot();
	static final int GRASS_WIDTH = 25;
	static final int HOUSE_WIDTH = 50;
	
	public void run() {
		// [optional] Set the scene to night by setting the background to black
		Robot.setWindowColor(Color.BLACK);
		
//		System.out.println("x: " + homeBot.getX());
//		System.out.println("y: " + homeBot.getY());
		
		// 1. Have a robot start on the left side of the window near the bottom.
		
		homeBot.setX(10); // left
		homeBot.setY(450); // toward the bottom

		// 2. Draw a flat-topped house of height 100 with grass after it (see picture).
		homeBot.setSpeed(100);
		homeBot.penDown();

		drawHouse("medium", Color.PINK);
		drawHouse("large", Color.DARK_GRAY);
		drawHouse("small", Color.BLUE);
		drawHouse("medium", Color.MAGENTA);
		drawHouse("medium", Color.ORANGE);
		drawHouse("large", Color.CYAN);
		drawHouse("small", Color.BLUE);
		drawHouse("large", Color.ORANGE);
		drawHouse("small", Color.RED);

		homeBot.hide();
	}
	
	// 3. Extract the piece of code that draws the house into a method. Draw 10 houses.
	
	void drawHouse(String size, Color color) {
		// 4. Change the method to take (int height) as a parameter. Draw 9 houses of different heights
		
		int height;
		
		// 5. Make the method take a String instead of an int.

		//        “small”                 60

		//        “medium”             120

		//        “large”                 250
		if(size.equals("small")) {
			height = 60;
		} else if (size.equals("medium")) {
			height = 120;
		} else if (size.equals("large")) {
			height = 250;
		} else {
			throw new IllegalArgumentException("size must be small, medium, or large");
		}
		// 6. Make the method take a color as well as a height. The houses are drawn in that color.
		homeBot.setPenColor(color);
		
		// re-orient
		homeBot.setAngle(0);
		// house
		homeBot.move(height);
		// 9. Make large houses have flat roofs
		if (size.equals("large")) {
			drawFlatRoof();
		} else { // 7. Give the houses peaked roofs
			drawPointyRoof(); // 8. Extract that roof code into a method “drawPointyRoof” and create a new method: “drawFlatRoof”.
		} 
		// orient downward
		homeBot.setAngle(-180);
		homeBot.move(height);
		
		// grass
		homeBot.turn(-90);
		homeBot.setPenColor(Color.GREEN);
		homeBot.move(GRASS_WIDTH);
	}
	
	void drawPointyRoof() {
		homeBot.turn(45);
		homeBot.move((int)(HOUSE_WIDTH / 2 * Math.sqrt(2)));
		homeBot.turn(90);
		homeBot.move((int)(HOUSE_WIDTH / 2 * Math.sqrt(2)));
	}
	
	void drawFlatRoof() {
		homeBot.turn(90);
		homeBot.move(HOUSE_WIDTH);
		homeBot.turn(90);
		
	}
}
