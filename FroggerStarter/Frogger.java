import objectdraw.*;
import java.awt.*;

public class Frogger extends WindowController{

    // Constants defining the sizes of the background components.
    private static final double HIGHWAY_LENGTH = 700;
    private static final double LANE_WIDTH = 100;
    private static final int NUM_LANES = 4;
    private static final double HIGHWAY_WIDTH = LANE_WIDTH * NUM_LANES;
    private static final double LINE_WIDTH = LANE_WIDTH / 10;

    // Constants defining the locations of the background components
    private static final double HIGHWAY_LEFT = 0;
    private static final double HIGHWAY_RIGHT = HIGHWAY_LEFT + HIGHWAY_LENGTH;
    private static final double HIGHWAY_TOP = LANE_WIDTH;
    private static final double HIGHWAY_BOTTOM = HIGHWAY_TOP + HIGHWAY_WIDTH;

    // Constants describing the lines on the highway
    private static final double LINE_SPACING = LINE_WIDTH / 2;
    private static final double DASH_LENGTH = LANE_WIDTH / 3;
    private static final double DASH_SPACING = DASH_LENGTH / 2;
        
    // Constants for describing the frog
    private static final double FROG_WIDTH = 83;

    // This method current just draws the highway.  
    // You will have to add instructions to create
    // the frog and the Lane ActiveObjects.
    public void begin()
    {
	// Draw the highway background
	new FilledRect (HIGHWAY_LEFT, 
                	HIGHWAY_TOP, 
                	HIGHWAY_LENGTH, 
                	HIGHWAY_WIDTH, 
                	canvas);

	// Draw the lane dividers
	int whichLine = 1;
	while (whichLine < NUM_LANES) {
	    if (whichLine == NUM_LANES / 2) {
		// The middle line is a no passing line
		drawNoPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) -
				   (LINE_SPACING / 2 + LINE_WIDTH));
	    }
	    else {
		drawPassingLine (HIGHWAY_TOP + (whichLine * LANE_WIDTH) -
				 (LINE_WIDTH / 2));
	    }
	    whichLine = whichLine + 1;
	}
	resize((int)HIGHWAY_LENGTH, (int)(HIGHWAY_WIDTH+3*LANE_WIDTH));


	// ADD YOUR CODE TO CREATE THE FROG AND THE LANES

    }

    // Draws a pair of solid yellow lines to represent a no passing 
    // divider between lanes
    // Parameter:  y - the top of the top line
    //
    // YOU SHOULD NOT NEED TO MODIFY THIS METHOD
    //
    public void drawNoPassingLine (double y) {
	// Draw the solid dividing lines
	FilledRect topLine = new FilledRect (HIGHWAY_LEFT, 
					     y, 
					     HIGHWAY_LENGTH, 
					     LINE_WIDTH, 
					     canvas);
	topLine.setColor (Color.yellow);

	FilledRect bottomLine = new FilledRect (HIGHWAY_LEFT, 
						y + LINE_WIDTH + LINE_SPACING,
						HIGHWAY_LENGTH, 
						LINE_WIDTH, 
						canvas);
	bottomLine.setColor (Color.yellow);
    }

    // Draws a dashed white line to represent a passing line dividing two 
    // lanes of traffic
    // Parameters:  y - the top of the line.
    //
    // YOU SHOULD NOT NEED TO MODIFY THIS METHOD
    //
    public void drawPassingLine (double y) {
	double x = HIGHWAY_LEFT;
	FilledRect dash;

	while (x < HIGHWAY_RIGHT) {
	    // Draw the next dash.
	    dash = new FilledRect (x, y, DASH_LENGTH, LINE_WIDTH, canvas);
	    dash.setColor (Color.white);
	    x = x + DASH_LENGTH + DASH_SPACING;
	}

    }

    // Note: Use onMousePress rather than onMouseClick to decide when to move the frog
    public void onMousePress(Location point)
    {

    }
    
	public static void main(String[] args) {
    	new Frogger().startController(500,500);
    }

}




