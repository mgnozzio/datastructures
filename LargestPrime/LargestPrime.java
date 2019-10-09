public class LargestPrime {

    public static void main(String[] args) {
	int x = (int)(Math.random() * 999999) + 2;
	System.out.println("The largest prime in " + x + 
			   " is " + largestPrime(x));
    }

    protected static boolean isPrime(int x){
	if(x == 2) return true;
	else if (x < 2) return false;
	else {
	    for(int i=2; i<Math.sqrt(x); i++){
		if(x % i == 0) return false;
	    }
	    return true;
	}
    }

    protected static int largestPrime(int x)  {
	String s = "" + x;
	// Iterate from the length of the word to 1
	for(int i=s.length(); i>0; i--){
	    int largest = 0;
	    // Iterate over the substrings of the length in question
	    for(int j=0; j + i <= s.length(); j++) {
		int n = Integer.parseInt(s.substring(j, j+i));
		// Check n > largest first, since it's less expensive
		// than isPrime.  Java has *short circuit evaluation*
		// so it won't even evaluate isPrime if > is false. 
		if(n > largest && isPrime(n)) largest = n;
	    }
	    if(largest > 0) return largest;
	}
	return -1;
    }
}