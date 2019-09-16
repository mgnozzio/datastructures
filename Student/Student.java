public class Student{

  /* Instance Variables
   * Instance variable store the state of the object
   */
  private String name;
  private String password;

  // Accessor Method
  public String getName() {
    return name;
  }

  // Mutator Method
  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String pw) {
    password = pw;
  }

  public void setPassword() {
    password = "PassW0rd!";
  }

  // Default Constructor
  public Student() {
    this.name = "John Smith";
  }

  // Constructor
  public Student(String name) {
    this.name = name;
  }

  // Static Method
  public static int grade() {
    return 100;
  }

    public static void main(String[] args){
      Student nico = new Student("Nico");
      nico.setPassword("Gr0ton!");
      System.out.println(nico.grade());
    }
}
