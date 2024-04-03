package Builder;
public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String address;
  
    public Person(String firstName, String lastName, int age, String phone, String address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.phone = phone;
      this.address = address;
    }
  
    public Person(String firstName, String lastName, int age, String phone) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
      this.phone = phone;
    }
  
    public Person(String firstName, String lastName, String phone, String address) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.phone = phone;
      this.address = address;
    }
  
    public Person(String firstName, String lastName, int age) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.age = age;
    }
  
    public Person(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }

    public int getAge() {
      return age;
    }

    public String getPhone() {
      return phone;
    }

    public String getAddress() {
      return address;
    }

    public String toString() {
      return "PersonBuilder [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
              + ", address=" + address + "]";
  }
}