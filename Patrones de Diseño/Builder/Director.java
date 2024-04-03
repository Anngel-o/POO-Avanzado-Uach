package Builder;

public class Director {
    public void constructPerson(Builder builder) {
        builder.setFirstName("Antonio");
        builder.setLastName("Bandera");
        builder.setAge(21);
        builder.setAddress("Chihuahua");
        builder.setPhone("1234567");
    }

    public void constructHomeless(Builder builder) {
        builder.setFirstName("Juan");
        builder.setLastName("Escutia");
        builder.setAge(40);
    }
}
