import objectdraw.WindowController;
import java.awt.Image;

public class FactoryExample extends WindowController {
	
	private static final int WINDOW_SIZE = 600;
	private static final int START_POS = 300;

	public void begin() {
		Image i = getImage("mothership.png");
		Mothership g = new Mothership(i, START_POS, START_POS, canvas);
	}
	
	public static void main(String[] args) {
		new FactoryExample().startController(WINDOW_SIZE, WINDOW_SIZE);
	}
	
	
}
