import java.util.Scanner;
public class LineSegment {
	
	private Point p1;
	private Point p2;
	
	public LineSegment(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public double getSlope() {
		return (p1.getY() - p2.getY())/(p1.getX() - p2.getX());
	}
	
	public Point getMidpoint() {
		double x = (p1.getX() + p2.getX())/2;
		double y = (p1.getY() + p2.getY())/2;
		return new Point(x,y);
	}
	
	public double getLength() {
		double dx = p1.getX() - p2.getX();
		double dy = p1.getY() - p2.getY();
		return Math.sqrt(dx*dx+dy*dy);
	}
	
	public String toString() {
		return "y = " + (int)(getSlope()*100)/100. + "(x-" + p1.getX() + ") +" + p1.getY();
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.print("Please enter x0: ");
		double x0 = s.nextDouble();
		System.out.print("Please enter y0: ");
		double y0 = s.nextDouble();
		Point p0 = new Point(x0, y0);
		
		System.out.print("Please enter x1: ");
		double x1 = s.nextDouble();
		System.out.print("Please enter y1: ");
		double y1 = s.nextDouble();
		Point p1 = new Point(x1, y1);
		
		LineSegment l = new LineSegment(p0,p1);
		
		System.out.println("Equation: " + l);
		System.out.println("Midpoint: " +l.getMidpoint());
		System.out.println("Length: " + l.getLength());
	}
}
