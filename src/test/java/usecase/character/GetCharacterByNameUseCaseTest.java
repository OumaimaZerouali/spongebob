package usecase.character;

import domain.character.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.character.CharacterJPAEntity;
import repository.character.CharacterRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCharacterByNameUseCaseTest {
    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private GetCharacterByNameUseCase getCharacterByNameUseCase;

    @Test
    public void givenCharacterWithName_whenGetCharacterByName_thenReturnCharacter() {
        var firstName = "Spongebob";
        var lastName = "SquarePants";

        CharacterJPAEntity characterEntity = new CharacterJPAEntity();
        characterEntity.setId("id");
        characterEntity.setFirstname("SpongeBob");
        characterEntity.setLastname("SquarePants");
        characterEntity.setOccupation("Fry Cook");
        characterEntity.setMotto("I’m ready!");
        characterEntity.setImageurl("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");

        when(characterRepository.findByName(firstName, lastName)).thenReturn(characterEntity);

        Character result = getCharacterByNameUseCase.execute(firstName, lastName);

        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("SpongeBob");
        assertThat(result.getLastName()).isEqualTo("SquarePants");
        assertThat(result.getOccupation()).isEqualTo("Fry Cook");
        assertThat(result.getMotto()).isEqualTo("I’m ready!");
        assertThat(result.getImageUrl()).isEqualTo("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");
    }

    @Test
    public void givenInvalidCharacterWithName_whenGetCharacterByName_thenReturnNull() {
        var firstName = "Fake";
        var lastName = "FAKER";

        when(characterRepository.findByName(firstName, lastName)).thenReturn(null);

        Character result = getCharacterByNameUseCase.execute(firstName, lastName);

        assertThat(result).isNull();
    }
}