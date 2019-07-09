import objectdraw.*;
public class StopWatch extends WindowController {

	private static final int WINDOW_SIZE = 400;
	
	private Timer t;
	
	public void begin() {
		t = new Timer(WINDOW_SIZE/2, WINDOW_SIZE/2, canvas);
	}
	
	public void onMouseClick(Location l) {
		t.click();
	}
	
	public static void main(String[] args) {
		new StopWatch().startController(WINDOW_SIZE, WINDOW_SIZE);
	}
	
}
