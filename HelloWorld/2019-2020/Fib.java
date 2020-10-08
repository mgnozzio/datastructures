
public class Fib {
	
	public static void main(String[] args) {
		// 1, 1, 2, 3, 5, 8, ...
		int t1 = 1;
		int t2 = 1;
		
		for(int i=0; i<10; i++) {
			// Code goes here
			// i++ = (i = i + 1)
			System.out.println(t1);
			int temp = t1;
			t1 = t2;
			t2 = t2 + temp;
		}
	}

}
