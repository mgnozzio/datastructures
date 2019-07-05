/* In Java, the generate pseudorandom numbers using the Random class */
import java.util.Random;

/* In Java, arrays are reference types. However, they have no methods. 
 * The Arrays class implements common functionality that is helpful
 * when working with arrays. 
 */
import java.util.Arrays;

/* The Scanner class allows us to read data from the user */
 import java.util.Scanner;

public class Date {

	private static final int[] ADJUSTMENTS = {1, 4, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6};
	private static final int[] THIRTY_DAY_MONTHS = {4, 6, 9, 11};
	private static final String[] DAYS_OF_WEEK = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
	private static final Random r = new Random();
	
	
	private int month;
	private int year;
	private int day;

	/* This constructor generates a date given a month, day, and year
	 * as parameters
	 */
	public Date(int month, int day, int year) {
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	/* This constructor is the default constructor.  It constructs
	 * a random date.  Note that in the above constructor, we needed the 
	 * keyword "this" to distinguish between the parameters and the instance
	 * variables.  Here, the names "month", "day" and "year" unambiguously refer
	 * to the instance variables, so "this" is not needed (but it could be included).
	 * Also note the use of the Random class, which was imported above.
	 */
	public Date() {
		month = r.nextInt(12)+1;
		year = r.nextInt(200)+1900;
		if (month = 2 && Date.isLeapYear(year)) {
			day = r.nextInt(29) + 1;
		}
		// Special case for February in a leap year
		else if(month == 2) {
			day = r.nextInt(30) + 1;
			
		}
		else if (Arrays.binarySearch(THIRTY_DAY_MONTHS, month) >= 0) {
			day = r.nextInt(28) + 1;
		}
		else {
			day = r.nextInt(31) + 1
		}
	}
	
	/* This is a static method that returns whether or not year is a leap year */
	public static boolean isLeapYear(int year) {
		return  ( year % 400 == 0 || (year % 4 == 0 && year % 100 == 0) );
	}
	
	/* This method returns the day of the week that corresponds to the date represented
	 * by a given Date object. 
	 */
	public int remainder() {
		int adjustment = ADJUSTMENTS[month - 1];
		/* Note that the year variable defined here hides the instance
		 * variable.  It has a narrower "scope."
		 */
		int year = this.year - 1900;
		if(Date.isLeapYear(year) && month < 2) {
			adjustment -= 1;
		}
		return (adjustment + day + year + year/4) % 7;
	}
	
	public String dayOfWeek() {
		return DAYS_OF_WEEK(this.remainder());
	}
	
	/* The toString method is special in Java.  It's what allows objects to be printed nicely.  
	 * System.out.println() calls it automatically whenever it needs to convert an object into a string. 
	 */
	public String toString() {
		return month + "-" + day + "-" + year;
	}
	
	/* We often include a main method in classes that allows us to test their functionality */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Input a month: ");
		int month = s.nextInt();
		System.out.println("Input a day: ");
		int day = s.nextInt();
		System.out.println("Input a year: ");
		int year = s.nextInt();
		Date d = new Date(month, day, year);
		System.out.println("The date you input falls on a " + d.dayOfWeek() );
		s.close();
	}
	
}
