import objectdraw.*;
import java.awt.Image;

public class Mothership extends ActiveObject {
	
	private VisibleImage image;
	private DrawingCanvas c;
	
	public Mothership(DrawingCanvas c, int x, int y, int height, int width, Image i) {
		image = new VisibleImage(i, x, y, height, width, c);
		this.c = c;
		start();
	}
	
	public void run() {
		while(true) {
			image.moveTo(c.getWidth()*Math.random()/2,
					c.getHeight()*Math.random()/2);
			new UFO(image.getX()+image.getWidth()/2, 
					image.getY()+image.getHeight()/2, 
					20, 20, c);
			image.sendToFront();
			pause(1000 + Math.random() * 500);
		}
	}

}
