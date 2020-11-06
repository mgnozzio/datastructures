import objectdraw.*;

public class UFO extends ActiveObject {
	
	private FilledOval o;
	private static final double SPEED = 3;
	
	public UFO(double x, double y, int height, int width, DrawingCanvas c) {
		o = new FilledOval(x, y, height, width, c);
		start();
	}
	
	public void run() {
		while(true) {
			o.move(SPEED, SPEED);
			pause(100);
		}
	}

}
