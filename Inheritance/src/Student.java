
public class Student extends Person {
	
	protected double gpa;
	
	public Student(int age, String name, double height, double gpa) {
		super(age, name, height);
		this.gpa = gpa;	
	}
	
	public double getGPA() { return gpa; }
	
	public static void main(String[] args) {
		double studentsInClass = 2;
		Student charlie = new Student(17, "Charlie", 5.75, 94);
		Person tommy = new Student(15, "Tommy", 5.9, 93);
		Prefect creed = new Prefect(17, "Creed", 5.3);
		System.out.println(tommy.getName() + " is " + tommy.getAge() + " years old.");
		System.out.println(charlie.getName() + "'s GPA is " + charlie.getGPA());
		creed.giveDemerit(charlie);
		Authority gnozzio = new Faculty(37, "Mr. Gnozzio", 5.11);
		Authority tommyG = new Prefect(18, "Tommy", 6);
		Authority[] authorityFigures = {gnozzio, tommyG}; 
		for(int i=0; i<authorityFigures.length; i++) {
			Authority a = authorityFigures[i];
			a.giveDemerit(creed);
		}
		for(Authority a : authorityFigures) {
			a.giveDemerit(creed);
		}
		

	}

}
