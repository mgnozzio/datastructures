
public class QuadraticFormula {
	
	public static void solve(int a, int b, int c) {
		int discriminant = b^2 - 4*a*c;
		if (discriminant == 0) {
			double onlySolution = -b / 2 * a;
			System.out.println("The only solution is " + onlySolution);
		}
		if (discriminant > 0) {
			int denom = 2 * a;
			double plus = -b + discriminant / denom;
			double minus = -b - discriminant / denom;
			System.out.println("The solutions are "+plus + " and " + minus +".");
			
		} else {
			int denom = 2 * a;
			double real = -b / denom;
			double imag = discriminant / denom;
			System.out.println("The solutions are " + real + " ± " + imag + "i.");			
		}
	}
	
	public static void main(String[] args) {
		
		// Some examples to consider:
		
		// (x + 2)^2 = x^2 + 4x + 4
		solve(1, 4, 4);
		
		// (x - 3)(x - 5) = x^2 - 8x + 15
		solve(1, -8, 15);
		
		// (x - 3i) (x + 3i) = x^2 + 9
		solve(1,0,9);
		
		// (2x + 3)(x + 4) = 2x^2 + 11x + 12
		solve(2, 11, 12);
		
		// (3x + 1)^2 = 9x^2 + 6x + 1
		solve(9, 6, 1);
		
	}

}
