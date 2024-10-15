package usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.CharacterJPAEntity;
import repository.CharacterRepository;
import domain.Character;

@Transactional
@ApplicationScoped
public class CreateOrUpdateCharacterUseCase {

    @Inject
    CharacterRepository characterRepository;

    public void execute(Character character) {
        CharacterJPAEntity existingCharacter = characterRepository.getCharacterByName(character.getFirstName(), character.getLastName());

        if (existingCharacter != null) {
            existingCharacter.setOccupation(character.getOccupation());
            existingCharacter.setMotto(character.getMotto());
            existingCharacter.setImageurl(character.getImageUrl());
            characterRepository.updateCharacter(existingCharacter);
        } else {
            characterRepository.createCharacter(character);
        }
    }
}

