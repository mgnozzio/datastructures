
public class Student implements People {
	
	// State / Fields / Instance Variable
	protected String name;
	private static int grade;
	
	// Behavior / Methods
	
	// Accessor Method
	public String getName() {
		return name;
	}
	
	// Mutator Method
	public void setName(String newName) {
		//name = newName;
		System.out.println("Names cannot be changed after birth");
	}
	
	/* Default Constructor
	public Student() {
		super();
		name = "Edric";
	}*/
	
	public Student(String n) {
		name = n;
		grade = 2;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public static void main(String[] args) {
		Student z = new Student("Ziad");
		Student o = new Student("Obi");
		Student[] students = {z,o};
		for(Student s:students) {
			System.out.println(s.getName() + "'s grade is " + s.getGrade());
		}
		z.setGrade(1);
		for(int i=0; i<students.length; i++) {
			Student s = students[i];
			System.out.println(s.getName() + "'s grade is " + s.getGrade());
		}
	}

}
