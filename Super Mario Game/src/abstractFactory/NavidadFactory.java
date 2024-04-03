package abstractFactory;

public class NavidadFactory implements CharacterFactory{

    @Override
    public Character createCharacter() {
        return new CharacterNavidad();
    }
}
