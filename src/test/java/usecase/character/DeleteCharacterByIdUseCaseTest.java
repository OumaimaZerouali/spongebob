package usecase.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.character.CharacterRepository;

import static org.mockito.Mockito.*;

public class DeleteCharacterByIdUseCaseTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private DeleteCharacterByIdUseCase deleteCharacterByIdUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenCharacterId_whenExecute_thenDeleteCharacter() {
        String characterId = "character-id";

        deleteCharacterByIdUseCase.execute(characterId);

        verify(characterRepository).deleteCharacter(characterId);
    }

    @Test
    public void givenNonExistentCharacterId_whenExecute_thenDoNotThrowException() {
        String nonExistentId = "non-existent-id";

        deleteCharacterByIdUseCase.execute(nonExistentId);

        verify(characterRepository).deleteCharacter(nonExistentId);
    }
}
