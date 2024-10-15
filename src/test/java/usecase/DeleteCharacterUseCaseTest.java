package usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.CharacterRepository;
import static org.mockito.Mockito.*;

public class DeleteCharacterUseCaseTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private DeleteCharacterUseCase deleteCharacterUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenCharacterId_whenExecute_thenDeleteCharacter() {
        String characterId = "character-id";

        deleteCharacterUseCase.execute(characterId);

        verify(characterRepository).deleteCharacter(characterId);
    }

    @Test
    public void givenNonExistentCharacterId_whenExecute_thenDoNotThrowException() {
        String nonExistentId = "non-existent-id";

        deleteCharacterUseCase.execute(nonExistentId);

        verify(characterRepository).deleteCharacter(nonExistentId);
    }
}
