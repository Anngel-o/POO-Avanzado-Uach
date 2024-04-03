package abstractFactory;

public class HalloweenFactory implements CharacterFactory{

    @Override
    public Character createCharacter() {
        return new CharacterHalloween();
    }
    
}
