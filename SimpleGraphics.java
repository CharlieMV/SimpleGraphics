/**
 *	SimpleGraphics.java
 *
 *	To compile Linux:	javac -cp .:acm.jar SimpleGraphics.java
 *	To execute Linux:	java -cp .:acm.jar SimpleGraphics
 *	To compile MS Powershell:	javac -cp ".;acm.jar" SimpleGraphics.java
 *	To execute MS Powershell:	java -cp ".;acm.jar" SimpleGraphics
 *
 *	@author	Charles Chang
 *	@since September 21, 2023
 */
 
/*	All package classes should be imported before the class definition.
 *	"java.awt.Color" means package java.awt contains class Color. */
import java.awt.Color;

/*	The following libraries are in the acm.jar file. */
import acm.program.GraphicsProgram;
import acm.graphics.GLabel;
import acm.graphics.GOval;
import acm.graphics.GPoint;
import acm.graphics.GPolygon;
import acm.graphics.GRect;
import acm.graphics.GRectangle;

public class SimpleGraphics extends GraphicsProgram {
	
	/*	All fields and constants should be declared here.
	 *	Only constants (final) are initialized here. 
	 * 	Initializing circle array and setting radius size */
	private GOval circle[] = new GOval[5];
	private final double RADIUS = 200;
	
	private GRect brick[][] = new GRect[10][10];
	private final double SIDE = 20;
	
	/**	The init() method is executed before the run() method.
	 *	All initialization steps should be performed here.
	 */
	public void init() {
		
	}
/******************************************************************************/
	/**	The run() method is executed after init().
	 *	The bulk of the program should be performed here.
	 *	Exercise hint: Use one-dimensional arrays for the GOval's and GRect's.
	 */
	public void run() {
		/*	DRAWING THE TARGET */
		for (int i = 0; i < circle.length; i++) {
			/*	Adjust radius based on i */
			double tempRadius = RADIUS * (6 - i) / 6;
			/*	New circle in each array slot*/
			circle[i] = new GOval(getWidth() / 2 - tempRadius, 
			getHeight() - tempRadius, 2 * tempRadius, 2 * tempRadius);
			/*	Color circle */
			circle[i].setFilled(true);
			/*	Fill circles red and white respectively for even odd */
			if (i % 2 == 0) circle[i].setFillColor(Color.RED);
			else circle[i].setFillColor(Color.WHITE);
			/*	Draw */
			add(circle[i]);
		}
		
		/*	DRAWING THE BRICKS */
		/*	Vertical */
		for (int i = 0; i < 10; i++) {
			/*	Horizontal */
			for (int j = 0; j < i; j++) {
				/*	New rect in each array slot */
				brick[j][i] = new GRect(getWidth() / 2 - 25 * i, i * 20,
				20, 50);
				brick[j][i].setFilled(false);
				add(brick[j][i]);
			}
		}
		
		
		/*
		 * Original code
		circle = new GOval(100, 100, RADIUS * 2, RADIUS * 2);
		circle.setFilled(true);
		circle.setFillColor(Color.RED);
		
		square = new GRect(300, 100, SIDE, SIDE);
		square.setFilled(true);
		square.setFillColor(Color.BLUE);
		
		add(circle);
		add(square);
		*/
	}
}
