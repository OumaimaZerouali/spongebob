package usecase;

import domain.Character;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.CharacterRepository;

import java.util.UUID;

@ApplicationScoped
public class GetCharacterByIdUseCase {

    @Inject
    CharacterRepository characterRepository;

    public Character execute(String id) {
        var entity = characterRepository.getCharacterById(id);

        if(entity == null) {
            return null; //TODO: AI AI AI
        }

        return new Character(
                entity.getFirstname(),
                entity.getLastname(),
                entity.getOccupation(),
                entity.getMotto(),
                entity.getImageurl()
        );
    }
}
