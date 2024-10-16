package usecase.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.character.CharacterRepository;

import static org.mockito.Mockito.verify;

class DeleteCharacterByNameUseCaseTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private DeleteCharacterByNameUseCase deleteCharacterByNameUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenCharacterWithName_whenExecute_thenDeleteCharacter() {
        var firstName = "Spongebob";
        var lastName = "SquarePants";

        deleteCharacterByNameUseCase.execute(firstName, lastName);

        verify(characterRepository).deleteByFirstNameAndLastName(firstName, lastName);
    }

    @Test
    public void givenNonExistentCharacterWithName_whenExecute_thenDoNotThrowException() {
        var firstName = "Fake";
        var lastName = "FAKER";

        deleteCharacterByNameUseCase.execute(firstName, lastName);

        verify(characterRepository).deleteByFirstNameAndLastName(firstName, lastName);
    }
}