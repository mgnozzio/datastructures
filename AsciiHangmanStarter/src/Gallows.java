import java.util.Arrays;

public class Gallows {
	
	/* Gallows look like this:
	 *    ____
	 *   |    |
	 *   |    O
	 *   |   \|/
	 *   |   / \
	 * __|__
	 */
	
	protected Man man;
	protected char[] frame;

	public Gallows() {
		/* TODO: Initialize instance variables and 
		 * otherwise construct the Gallows object.
		 */
	}
	
	public void makeCenterPost() {
		/* TODO: Modify the frame to include
		 * the central post.
		 */
	}
	
	public void makeBeam() {
		/* TODO: Modify the frame to include
		 * the top beam. 
		 */
		
	}
	
	public void makeBase() {
		/* TODO: Modify the frame to include the
		 * base of the gallows. 
		 */
	}
	
	public void makeRope() {
		/* TODO: Modify the frame to include the rope. */
	}
	
	public void hang() {
		/* TODO: hang the hangman */
	}
	
	public boolean isAlive() {
		/* TODO: Check if the hangman is alive */
		return false;
	}
	
	public String toString() {
		/* TODO: Render the hangman as a string
		 */
		String s = "";
		return s;
	}
	
	/* This code is included to allow you to test the
	 * Gallows independently from the Hangman code. 
	 */
	public static void main(String[] args) {
		Gallows g = new Gallows();
		System.out.println(g);
		for(int i=0; i< Man.MAX_INCORRECT; i++) {
			g.hang();
			System.out.println(g);
		}
	}
}
