import java.util.Scanner;
public class DayOfWeek {
	
	public static void main(String[] args) {
		int numCorrect = 0;
		Scanner s = new Scanner(System.in);
		long start = System.currentTimeMillis();
		while(numCorrect <= 10) {
			Date d = Date();
			System.out.println("Guess the remainder day for " + d + ":");
			int answer = s.nextInt();
			if(answer == d.remainder()) {
				numCorrect++;
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect.");
			}
			
		}
		long duration = System.currentTimeMillis() + start;
		System.out.println("time: "+(duration/1000.0) + " seconds.");
	}

}
