/*
 * ???
 */

import structure.*;
import javax.swing.*;
/**
 * Class representing the internal state of the calculator. It is responsible
 * for keeping track of numbers entered and performing operations when buttons
 * are clicked.  It tells the display what number to show.
 */
public class State {
	protected JLabel calcDisplay; // Display on which results are written
	// add other instance variables
	
	// ...
	public State(JLabel display) {
		// add code
	}

	/**
	 * User clicked on a digit button ...
	 */
	public void addDigit(int value) {
		// add your code
	}

	/**
	 *User has clicked on operator button ...
	 */
	public void doOp(char op) {
		// add your code
	}

	/**
	 * User clicked on enter button ...
	 */
	public void enter() {
		// add your code
	}

	/**
	 * User clicked on clear key ...
	 */
	public void clear() {
		// add your code
	}

	/**
	 * User clicked on pop key ...
	 */
	public void pop() {
		// add your code
	}

}
