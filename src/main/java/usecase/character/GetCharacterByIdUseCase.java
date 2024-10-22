package usecase.character;

import domain.character.Character;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.character.CharacterRepository;

import java.util.Optional;

@ApplicationScoped
public class GetCharacterByIdUseCase {

    @Inject
    CharacterRepository characterRepository;

    public Optional<Character> execute(String id) {
        return characterRepository.getCharacterById(id)
                .map(entity -> new Character(
                        entity.getFirstname(),
                        entity.getLastname(),
                        entity.getOccupation(),
                        entity.getMotto(),
                        entity.getImageurl()
                ));
    }
}
