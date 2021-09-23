import java.util.Random;
public class Pi {
	
	public static int gcd(int a, int b) {
		int s = a;
		if(b<a) s=b;
		for(int i=s; i>1; i--) {
			if(a%i == 0 && b%i==0) return i;
		}
		return 1;
	}
	
	public static void main(String[] args) {
		int trials = 1000000;
		double successes = 0;
		Random r = new Random();
		for(int i=0; i<trials; i++) {
			int a = r.nextInt(10000);
			int b = r.nextInt(10000);
			if(gcd(a,b)==1) successes++;
		}
		double p = successes/trials;
		System.out.println("Pi is approximately "+ Math.sqrt(6/p));
	}

}
