import java.util.Arrays;
public class Man {
	
	/*  An ASCII Hangman looks like this:
	 *   O 
	 *  \|/
	 *  / \
	 */

	protected static final int MAX_INCORRECT = 6;
	protected int numIncorrect;
	protected char[] body;
	
	public Man() {
		/* TODO: Intiaialize the Man object */
	}
	
	public boolean isAlive() {
		/* TODO: Check if the man is alive */
		return false;
	}
	
	public void hang() {
		/* TODO: modify the man data to reflect
		 * a new incorrect guess. 
		 */
	}
	
	public String toString() {
		/* TODO: Render the man as a string. */
		return "";
	}
	
	protected char[] toCharArray() {
		/* TODO: Return the relevant data */
		return null;
	}
	
	/* Again, this main method is provided to assist
	 * with testing. 
	 */
	public static void main(String[] args) {
		Man m = new Man();
		for(int i=0; i<Man.MAX_INCORRECT; i++) {
			m.hang();
			System.out.println(m);
		}
	}
	
}
