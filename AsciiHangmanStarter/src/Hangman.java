import java.io.Console;
import java.util.Scanner;

public class Hangman {
	
	public static void main(String[] args) {
		System.out.println("Welcome to the ASCII Version of Hangman!");
		
		Console c = System.console();
		Scanner s = new Scanner(System.in);
		char[] letters;
		
		String prompt = "Please enter a secret word: ";
		if(c != null) {
			letters = c.readPassword(prompt);
			for(int i=0; i<letters.length; i++) {
				letters[i] = Character.toUpperCase(letters[i]);
			}
		} else {
			System.out.println("For best results, please run this from the command line.");
			System.out.print(prompt);
			letters = s.nextLine().trim().toUpperCase().toCharArray();
			for(int i=0; i<10000; i++) System.out.println();
		}
		
		// TODO: Write the code to play Hangman here.

	}

}
