package usecase.character;

import domain.character.Character;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.character.CharacterRepository;

@Transactional
@ApplicationScoped
public class CreateOrUpdateCharacterUseCase {

    @Inject
    CharacterRepository characterRepository;

    public void execute(Character character) {
        var existingCharacterOpt = characterRepository.getCharacterByName(character.getFirstName(), character.getLastName());

        if (existingCharacterOpt.isPresent()) {
            var existingCharacter = existingCharacterOpt.get();
            existingCharacter.setOccupation(character.getOccupation());
            existingCharacter.setMotto(character.getMotto());
            existingCharacter.setImageurl(character.getImageUrl());
            characterRepository.updateCharacter(existingCharacter);
        } else {
            characterRepository.createCharacter(character);
        }
    } // TODO: NOT REALLY FAN OF THIS
}

