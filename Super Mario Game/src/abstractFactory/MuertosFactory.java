package abstractFactory;

public class MuertosFactory implements CharacterFactory{

    @Override
    public Character createCharacter() {
        return new CharacterMuertos();
    }
    
}
