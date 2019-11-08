import objectdraw.*;

public class Spaceship extends ActiveObject {

	private static final int SIZE = 5;
	private static final int SPEED = 3;
	private FilledOval o;
	
	public Spaceship(double x, double y, DrawingCanvas c) {
		o = new FilledOval(x,y,SIZE,SIZE,c);
		start();
	}
	
	public void run() {
		while(true) {
			o.move(SPEED, SPEED);
			pause(SPEED);
		}
	}
	
}
