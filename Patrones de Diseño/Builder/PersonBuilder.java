package Builder;

public class PersonBuilder implements Builder{
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String address;

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public void setPhone(String phone) {
        this.phone = phone;
    }
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public Person getResult() {
        return new Person(firstName, lastName, age, phone, address);
    }
}
