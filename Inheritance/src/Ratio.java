
public class Ratio {
	
	private int n;
	private int d;
	
	public Ratio(int n, int d) {
		this.n = n;
		this.d = d;
	}
	
	public Ratio(int n) {
		this.n = n;
		this.d = 1;
		
	}
	
	public Ratio() {
		this.n = 0;
		this.d = 1;
	}
	
	public Ratio add(Ratio r) {
		System.out.println((this.n*r.d + r.n*this.d*1.0)/(this.d*r.d));
		return new Ratio((this.n*r.d + r.n*this.d)/(this.d*r.d));
	}
	
	// Overriding
	public String toString() {
		return n + "/" + d;
	}
	
	public static void main(String[] args) {
		Ratio r1 = new Ratio(11);
		Ratio r2 = new Ratio(17,3);
		Ratio r3 = r1.add(r2);
		System.out.println("The sum of these is: "+r3.toString());
	}

}
