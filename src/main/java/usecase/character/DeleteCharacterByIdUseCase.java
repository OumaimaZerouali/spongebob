package usecase.character;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.character.CharacterRepository;

@Transactional
@ApplicationScoped
public class DeleteCharacterByIdUseCase {

    @Inject
    CharacterRepository characterRepository;

    public void execute(String id){
        characterRepository.deleteCharacter(id);
    }
}
