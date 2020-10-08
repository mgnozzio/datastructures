/*
 
 *
 **
 ****
 ********
 ****
 **
 *
 
 
 y = g(f(x))
 
 */
public class Parameters {

	public static void main(String[] args) {
		
		System.out.println(sqrtOfAbs(-8));
		
		String toPrint = "";
		
		toPrint += repeatSymbol(1,'*');
		// toPrint = toPrint + repeatSymbol(1,'*');
		
		toPrint += repeatSymbol(2,'#');
		toPrint += repeatSymbol(4,'*');
		toPrint += repeatSymbol(8,'#');
		toPrint += repeatSymbol(4,'*');
		toPrint += repeatSymbol(2,'#');
		toPrint += repeatSymbol(1,'*');
		System.out.println(toPrint);
		
	}
	
	public static double sqrtOfAbs(double d) {
		return Math.sqrt(Math.abs(d));
	}
	
	public static String repeatSymbol(int numStars, char c) {
		
		String answer = "";
		
		for(int i=0; i < numStars; i++) {
			answer = answer + c;
		}
		answer = answer + '\n';
		
		return answer;
		
	}
	
}
