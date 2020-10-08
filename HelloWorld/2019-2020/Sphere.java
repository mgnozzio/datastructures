import java.util.Scanner;
import java.lang.Math;

public class Sphere {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		// Primitive Types
		//int i = 9;
		//int j = 7;
		//System.out.print(i+j-j*i/2);
		// PEMDAS, Left to Right
		// (9 + 8) - ((8 * 9) / 2)
		
		//double i = 9;
		//double j = 7;
		//System.out.print(i+j-j*i/2);
		
//		char c = 'a';
//		System.out.println(c+1);
//		
//		boolean b = true;
//		boolean b1 = false;
//		System.out.println(b && b1);
//		System.out.println(b || b1);
//		System.out.println(!b);
		
		// SA of a Sphere:  4*pi*r^2
		
		System.out.println(-15/10);
		System.out.println("What is the radius of the sphere?");
		double r = s.nextDouble();
		System.out.println("The SA of the sphere is " + 4*Math.PI*r*r + " square units.");

	}

}
