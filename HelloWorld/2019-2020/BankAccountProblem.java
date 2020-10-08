public class BankAccountProblem {

	public static void main(String[] args) {
		double initial = 1000;
		double rate = 0.065;
		double annual_deposit = 100.00;
		int years = 25;
		printTable(initial, rate, annual_deposit, years);
	}
	
	public static void printTable(double initial, 
								double rate, 
								double annual_deposit, 
								int years){
		for(int i=0; i<years; i++) {
			System.out.print(i + "\t");
			printCurrency(initial);
			System.out.print("\t");
			double interest = initial * rate;
			printCurrency(interest);
			System.out.print("\t");
			printCurrency(annual_deposit);
			System.out.print("\t");
			initial = initial + interest + annual_deposit;
			printCurrency(initial);
			System.out.println();
		}
	}
	
	/* This is what I hoped you'd come up with */
	public static void printCurrencySimple(double d) {
		int cents = (int) (d * 100);
		double dollars = cents / 100.0;
		System.out.print("$" + dollars);
	}
	
	/* But this is slightly better because it always gives
	 * you two decimal places.  There are also string
	 * formatting options that we'll cover after we talk
	 * about return values.
	 */
	public static void printCurrency(double amount) {
		int cents = (int) (amount * 100);
		int remaining = cents;
		String result = remaining % 10 + "";
		remaining = remaining / 10;
		result = "." + remaining % 10 + result;
		remaining = remaining / 10;
		for(; remaining > 0; remaining /= 10) {
			result = remaining % 10 + result;
		}
		System.out.print("$" + result);
	}

}
