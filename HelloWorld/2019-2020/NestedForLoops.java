public class NestedForLoops {
	
	public static void main(String[] args) {
		
		for(int i=0; i<7; i++) {
			for(int j=0; j < 6-i; j++) {
				System.out.print("*");
			}
			for(int j=0; j < i+1; j++) {
				System.out.print(" ");
			}
			for(int j=0; j < 6-i; j++) {
				System.out.print("//");
			}
			for(int j=0; j < i; j++) {
				System.out.print("\\\\");
			}
			for(int j=0; j < i+1; j++) {
				System.out.print(" ");
			}
			for(int j=0; j < 6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
