package abstractFactory;

public class Aplication {
    private Character character;

    public Aplication(CharacterFactory characterFactory){
        this.character = characterFactory.createCharacter();
    }

    public String create() {
        return character.create();
    }
}
