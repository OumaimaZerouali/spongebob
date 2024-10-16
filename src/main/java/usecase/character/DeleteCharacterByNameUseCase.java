package usecase.character;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.character.CharacterRepository;

@Transactional
@ApplicationScoped
public class DeleteCharacterByNameUseCase {
    @Inject
    CharacterRepository characterRepository;

    public void execute(String firstName, String lastName) {
        characterRepository.deleteByFirstNameAndLastName(firstName, lastName);
    }
}
