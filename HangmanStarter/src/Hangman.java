import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import objectdraw.*;
public class Hangman extends WindowController {

	// GUI Elements
	protected Gallows gallows;
	
	protected static final int WINDOW_SIZE = 600;
    public void begin()
    {
            // Get ready to handle key focuses
            requestFocus();
            gallows = new Gallows(WINDOW_SIZE/4.0, WINDOW_SIZE * 2.0/3, canvas);
    }

    
    public void onMousePress(Location point) {
    	if(gallows.isAlive()) gallows.hang();
    }
    
    
    public static void main(String[] args) { 
        new Hangman().startController(WINDOW_SIZE, WINDOW_SIZE); 
	}
	
}
