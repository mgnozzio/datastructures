
public class Prefect extends Student  implements Authority {
	
	public Prefect(int age, String name, double height) {
		super(age, name, height, 99);
	}
	
	public void giveDemerit(Student s) {
		System.out.println(this.getName() + " gave " + s.getName() + " a demerit.");
	}

}
