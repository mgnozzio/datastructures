
public class Senior extends Student {
	
	private Student advisee;
	
	public Senior(String name, Student advisee) {
		super(name);
		this.advisee = advisee;
	}

	public static void main(String[] args) {
		Student z = new Student("Ziad");
		Student j = new Student("Jia");
		Student o = new Senior("Obi", j);
		Senior m = new Senior("Magnus", j);
		Faculty f = new Faculty("Mr. Das");
		// People[] people = {z,o,f};
		People[] people = new People[3];
		people[0] = z;
		people[1]=o;
		people[2]=f;
		for(People s:people) {
			System.out.println(s.getName());
		}
	}
	
}
