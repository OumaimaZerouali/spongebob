package usecase;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.CharacterRepository;

@Transactional
@ApplicationScoped
public class DeleteCharacterUseCase {

    @Inject
    CharacterRepository characterRepository;

    public void execute(String id){
        characterRepository.deleteCharacter(id);
    }
}
