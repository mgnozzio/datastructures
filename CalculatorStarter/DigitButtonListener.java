/*
	DigitButton.java - 1/97 Kim B. Bruce
*/

import java.awt.event.*;

/**
	Class representing buttons with numbers on them.
**/
public class DigitButtonListener implements ActionListener
{
	protected int value;					// digit that button represents
	protected State calcState;		// Does all the computation - buttons inform it of events.
	
	/**
		Button knows own value and the state so can communicate with it.
	**/
	public DigitButtonListener(int newValue, State state)
	{
		value = newValue;
		calcState = state;
	}
	
	/**
		pre:  User clicked on the button.
		post:  Informed state that it was clicked on and what its value is.
	**/
	public void actionPerformed(ActionEvent evt)
	{
		calcState.addDigit(value); 
	}
}