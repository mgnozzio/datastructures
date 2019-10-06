import objectdraw.*;

public class Man {
	protected FramedOval head;
	protected DrawableInterface[] bodyParts;
	
	protected static final int MAX_INCORRECT = 6;
	protected static final int HEAD_SIZE = 80;
	protected static final int BODY_SIZE = 80;
	protected static final int ARM_LENGTH = 50;
	protected int numIncorrect;

	public Man(double xPos, double yPos, DrawingCanvas canvas) {
		/* TODO: Initialize all of the man's body parts.
		 * Then, use the clear method to hide them all. 
		 * The given (xPos, yPos) specifies the coordinates
		 * for the top of the man's head.
		 */
	}
	
	public void clear() {
		/* TODO: Hide all of the man's body parts */
	}
	
	public void hang() {
		/* TODO: Hang the man */
	}
	
	public boolean isAlive() {
		/* TODO: Return true if the man is not fully
		 * hanged.  Otherwise, return false. 
		 */
		return false;
	}
	
}
