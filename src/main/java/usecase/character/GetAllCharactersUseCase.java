package usecase.character;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.character.CharacterRepository;
import domain.character.Character;

import java.util.List;

@ApplicationScoped
public class GetAllCharactersUseCase {

    @Inject
    CharacterRepository characterRepository;

    public List<Character> execute() {
        return characterRepository.getCharacters().stream().map(
                characterEntity -> new Character(
                        characterEntity.getFirstname(),
                        characterEntity.getLastname(),
                        characterEntity.getOccupation(),
                        characterEntity.getMotto(),
                        characterEntity.getImageurl())
        ).toList();
    }
}
