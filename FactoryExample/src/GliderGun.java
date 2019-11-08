import objectdraw.*;
import java.awt.Image;

public class GliderGun extends ActiveObject {
	
	private static final int SIZE = 100;
	private static final int MIN_WAIT = 1000;
	
	private DrawingCanvas canvas;
	private VisibleImage vi;

	public GliderGun(Image i, int x, int y, DrawingCanvas c) {
		vi = new VisibleImage(i, x,y, SIZE,SIZE,c);
		canvas = c;
		start();
	}
	
	public void run() {
		while(true) {
			vi.moveTo(Math.random() * canvas.getHeight()/2, 
					Math.random() * canvas.getWidth()/2
			);
			new Spaceship(vi.getX()+vi.getWidth(), 
					vi.getY()+vi.getHeight(), 
					canvas
			);
			pause((int)(Math.random()*MIN_WAIT/2)+MIN_WAIT);
		}
	}
	
}
