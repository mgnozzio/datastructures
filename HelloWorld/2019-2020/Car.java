public class Car {

	private String make;
	private String model;
	
	public Car(String make, String model) {
		this.make = make;
		this.model = model;
	}
	
	public static void main(String[] args) {
		Car c = new Car("Honda", "Civic");
	}
}
