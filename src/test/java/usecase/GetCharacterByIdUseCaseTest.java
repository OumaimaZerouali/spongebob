package usecase;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.character.CharacterJPAEntity;
import repository.character.CharacterRepository;
import domain.character.Character;
import usecase.character.GetCharacterByIdUseCase;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

public class GetCharacterByIdUseCaseTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private GetCharacterByIdUseCase getCharacterByIdUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenCharacterId_whenGetCharacterById_thenReturnCharacter() {
        String characterId = "b3158f8e-5e10-4e94-aaf2-3049e7a5e6a3";
        CharacterJPAEntity characterEntity = new CharacterJPAEntity();
        characterEntity.setFirstname("SpongeBob");
        characterEntity.setLastname("SquarePants");
        characterEntity.setOccupation("Fry Cook");
        characterEntity.setMotto("I’m ready!");
        characterEntity.setImageurl("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");

        when(characterRepository.getCharacterById(characterId)).thenReturn(characterEntity);

        Character result = getCharacterByIdUseCase.execute(characterId);

        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("SpongeBob");
        assertThat(result.getLastName()).isEqualTo("SquarePants");
        assertThat(result.getOccupation()).isEqualTo("Fry Cook");
        assertThat(result.getMotto()).isEqualTo("I’m ready!");
        assertThat(result.getImageUrl()).isEqualTo("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");
    }

    @Test
    public void givenInvalidCharacterId_whenGetCharacterById_thenReturnNull() {
        when(characterRepository.getCharacterById(anyString())).thenReturn(null);

        Character result = getCharacterByIdUseCase.execute("invalid-id");

        assertThat(result).isNull();
    }
}
