
public class Faculty extends Person implements Authority {
	
	public Faculty(int age, String name, double height) {
		super(age, name, height);
	}
	
	public void giveDemerit(Student s) {
		System.out.println(this.getName() + " gave " + s.getName() + " 2 demerits.");
	}

}
