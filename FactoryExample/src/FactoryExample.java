import objectdraw.WindowController;
import java.awt.Image;

public class FactoryExample extends WindowController {
	
	private static final int WINDOW_SIZE = 600;
	private static final int START_POS = 300;
	private static final int HEIGHT = 100;
	private static final int WIDTH=150;

	public void begin() {
		Image i = getImage("mothership.png");
		Mothership m = new Mothership(i, START_POS, START_POS, WIDTH, HEIGHT, canvas);
	}
	
	public static void main(String[] args) {
		new FactoryExample().startController(WINDOW_SIZE, WINDOW_SIZE);
	}
	
	
}
