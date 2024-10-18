package usecase.character;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.character.CharacterRepository;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class DeleteCharacterByNameUseCaseTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private DeleteCharacterByNameUseCase deleteCharacterByNameUseCase;

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