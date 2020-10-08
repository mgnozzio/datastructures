import java.util.*;
public class HelloWorld {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Input a decimal number: ");
		int dec = s.nextInt();
		System.out.println(dec);
		// while (condition) <statement>
		// while (condition) single statement;
		// while (condition) { ... }
		boolean b = true;
		int[] array_of_bools = new int[5];
		System.out.println(array_of_bools);
		System.out.println(array_of_bools[0]);
		for(int i=0; i<array_of_bools.length; i++) {
			System.out.println(array_of_bools[i]);
		}
	}
	

}
