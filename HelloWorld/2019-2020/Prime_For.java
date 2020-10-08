import java.util.Scanner;
public class Prime {

	public static void main(String[] args) {
		System.out.print("Input a positive integer: ");
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		
		if(num <= 1) System.out.println(num + " is not a positive integer.");
		else if(isPrime(num)) {
			System.out.println(num + " is prime.");
		} else {
			System.out.println(num + " is not prime.");
		}

	}
	

	private static boolean isPrime(int num) {
		if(num <= 1) return false;
		
		for(int i = 2; i <= Math.sqrt(num); i++) {
			if(num % i == 0) return false;
		}
		
		return true;
	}

}
