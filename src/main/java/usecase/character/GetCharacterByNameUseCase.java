package usecase.character;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.character.CharacterRepository;
import domain.character.Character;

@ApplicationScoped
public class GetCharacterByNameUseCase {
    @Inject
    CharacterRepository characterRepository;

    public Character execute(String firstName, String lastName) {
        var characterEntity = characterRepository.findByName(firstName, lastName);

        return new Character(
                characterEntity.getFirstname(),
                characterEntity.getLastname(),
                characterEntity.getOccupation(),
                characterEntity.getMotto(),
                characterEntity.getImageurl()
        );
    }
}
