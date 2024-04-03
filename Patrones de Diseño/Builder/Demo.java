package Builder;

public class Demo {
    public static void main(String[] args) {
        Director director = new Director();

        PersonBuilder pbuilder = new PersonBuilder();
        director.constructPerson(pbuilder);
        PersonBuilder hBuilder = new PersonBuilder();
        director.constructHomeless(hBuilder);

        Person person = pbuilder.getResult();
        System.out.println(person.toString());
        Person homeless = hBuilder.getResult();
        System.out.println(homeless.toString());
      }
}
