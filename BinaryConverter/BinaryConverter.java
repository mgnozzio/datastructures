import java.util.Scanner;

public class BinaryConverter {

    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	System.out.println("What number would you like to convert?");
	int n = s.nextInt();
	convert(n, 2, "Binary: 0b");
	convert(n, 8, "Octal: 0");
	convert(n, 16, "Hexadecimal: 0x");
    }

    public static void convert(int n, int base, String label){
	int i = 0;
	String result = "";
	while(Math.pow(base, i+1) <= n) i++;
	while(i >= 0) {
	    int p = (int) (Math.pow(base,i));
	    int v = n/p;
	    char c;
	    if(v < 10) c = (char) ((int)'0' + v);
	    else c = (char)((int)'a' + (v -10));
	    result += c;
	    n -= v * p;
	    i--;
	}
	System.out.println(label + result);
    }
}