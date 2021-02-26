import junit.framework.TestCase; 
import javax.swing.*; 
/* 
 * Created on Apr 4, 2004 
 * Test class for State class
 */ 
public class StateTest extends TestCase { 
	private JLabel display;  // dummy display for testing
	private State st;        // sample state object
	
	// set up state with 2 on top of stack and 9 below it.
	public void setUp(){ 
		display = new JLabel("0"); 
		st = new State(display); 
		st.addDigit(9); 
		st.enter(); 
		st.addDigit(2); 
		st.enter(); 
	} 
	
	// check that if 2 on stack and add digits 7, 5, and then
	// hit enter that display will show "75"
	public void testAddDigit() { 
		assertEquals("2",display.getText()); 
		st.addDigit(7); 
		assertEquals("7",display.getText()); 
		st.addDigit(5); 
		assertEquals("75",display.getText()); 
		st.enter(); 
		assertEquals("75",display.getText()); 
	} 
	
	// check that if stack has 4, 2, and 9, then executing plus twice
	// gives "6" and then "15".
	public void testPlus() { 
		st.addDigit(4); 
		st.enter(); 
		st.doOp('+'); 
		assertEquals("6",display.getText()); 
		st.doOp('+'); 
		assertEquals("15",display.getText()); 
	} 
	
	public void testMult() { 
	} 
	
	
	public void testMinus() { 
	} 
	
	public void testDiv() { 
	} 
	
	public void testClear() { 
	} 
	
	// check if 2 and 9 on stack that if pop once get "9" in display
	// and if pop again have "0" on stack and remains if pop once more.
	public void testPop() { 
		st.pop(); 
		assertEquals("9",display.getText()); 
		st.pop(); 
		assertEquals("0",display.getText()); 
		st.pop(); 
		assertEquals("0",display.getText()); 
	} 
	
}