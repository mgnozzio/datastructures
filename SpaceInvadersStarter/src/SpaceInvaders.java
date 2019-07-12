import objectdraw.*;
import java.awt.*;
import java.awt.event.*;

public class SpaceInvaders extends WindowController implements KeyListener {


	// Constants for the window
	private static final int HEIGHT=800;
	private static final int WIDTH = 800;
	
	// Constants for the space ship. 
	// Move into a dedicated class?
	private static final int SHIP_WIDTH = 50;
	private static final int SHIP_HEIGHT = 50;
	VisibleImage ship;

	// remember whether a key is currently depressed
	private boolean keyDown;
	
	public void begin() {
		
		/* This code will make it so the window cannot be resized */
		/*
		Container c = this;
		while(! (c instanceof Frame)) {
			c = c.getParent();
		}
		((Frame)c).setResizable(false);
		*/
		FilledRect background = new FilledRect(0,0,WIDTH, HEIGHT, canvas);
		background.setColor(Color.BLACK);
		
		
		Image shipImage = getImage("ship.png");
		ship = new VisibleImage(shipImage, WIDTH/2, HEIGHT/2, SHIP_WIDTH, SHIP_HEIGHT, canvas);
		
		requestFocus();
		addKeyListener(this);
		canvas.addKeyListener(this);
	}
	

	
	public void onMouseClick(Location l) {
	}
	
	
	// Handle the arrow keys by telling the ship to go in the direction of the arrow.
	public void keyTyped(KeyEvent e)
	{
		if ( e.getKeyCode() == KeyEvent.VK_SPACE || 
				 e.getKeyCode() == KeyEvent.VK_UP ) {
	       
			    // insert code to handle press of up arrow or space bar
			}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT ) {
 
		    // insert code to handle press of left arrow

		} else if ( e.getKeyCode() == KeyEvent.VK_RIGHT ) {
			
			// insert code to handle press of right arrow			
        }
	}

	// Remember that the key is no longer down.
	public void keyReleased(KeyEvent e)
	{
		keyDown = false;
		if (e.getKeyCode() == KeyEvent.VK_LEFT || 
                    e.getKeyCode() == KeyEvent.VK_RIGHT ) {
		    // insert code to handle key release (optional stopping of base)
		}
	}

	// Handle the pressing of the key the same as typing.
	public void keyPressed(KeyEvent e)
	{
		if (!keyDown)
		{
			keyTyped(e);
		}

		keyDown = true;
	}
	
    public static void main(String[] args) { 
        new SpaceInvaders().startController(WIDTH, HEIGHT); 
	}
	
}
