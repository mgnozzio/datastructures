
public class Faculty implements People, Alumns{
	
	private String name;
	
	public Faculty(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void greetStudent(Student s) {
		System.out.println("Hello "+ s.getName() + ". I hope you're ready for your quiz.");
	}
	
	public static void main(String[] args) {
		String c = "😀";
		System.out.println(c);
		Faculty f = new Faculty("Mr. Gnozzio");
		Student s = new Student("Nadia");
		f.greetStudent(s);
	}

}
