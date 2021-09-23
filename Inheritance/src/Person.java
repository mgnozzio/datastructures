
public class Person extends Object {
	
	// Instance Variables
	protected int age;
	private String name;
	protected double height;
	
	// Constructors initialize the state of the object
	public Person(int age, String name, double height) {
		this.age = age;
		this.name = name;
		this.height = height;
	}
	
	public Person(String n, double h) {
		age = 0;
		name = n;
		height = h;
	}
	
	// Default Constuctor
	public Person() {
		age = 0;
		name = "John Doe";
		height = 1;
	}
	
	// Accessor Methods
	public int getAge() { return age; } // get_age
	public String getName() { return name; }
	public double getHeight() { return height; }
	
	// Mutator Methods
	public void age(int years) {
		age += years;
	}
	
	public void grow(int feet) {
		height += feet;
	}
	
	public static void main(String[] args) {
		Person charlie = new Person(17, "Charlie", 5.75);
		Person tommy = new Person(15, "Tommy", 5.9);
		System.out.println(tommy.getName() + " is " + tommy.getAge() + " years old.");
		System.out.println(charlie.getName() + " is " + charlie.getAge() + " years old.");

	}

}
