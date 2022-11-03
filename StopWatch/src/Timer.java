import objectdraw.*;
public class Timer extends ActiveObject{
	
	private Text text;
	private double millis;
	private boolean running;
	
	public Timer(int x, int y, DrawingCanvas canvas) {
		millis = 0;
		text = new Text(millis/1000, x, y, canvas);
		text.setFontSize(36);
		text.move(-1*text.getWidth(), -1*text.getHeight());
		start();
	}
	
	public void click() {
		running = !running;
	}
	
	public void run() {
		while(true) {
			if(running) {
				millis++;
				text.setText(millis/1000);
			}
			pause(1);
		}
	}

}
