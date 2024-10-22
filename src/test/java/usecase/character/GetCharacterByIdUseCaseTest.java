package usecase.character;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.character.CharacterJPAEntity;
import repository.character.CharacterRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetCharacterByIdUseCaseTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private GetCharacterByIdUseCase getCharacterByIdUseCase;

    @Test
    public void givenCharacterId_whenGetCharacterById_thenReturnCharacter() {
        String characterId = "b3158f8e-5e10-4e94-aaf2-3049e7a5e6a3";
        CharacterJPAEntity characterEntity = new CharacterJPAEntity();
        characterEntity.setFirstname("SpongeBob");
        characterEntity.setLastname("SquarePants");
        characterEntity.setOccupation("Fry Cook");
        characterEntity.setMotto("I’m ready!");
        characterEntity.setImageurl("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");

        when(characterRepository.getCharacterById(characterId)).thenReturn(Optional.of(characterEntity));

        var result = getCharacterByIdUseCase.execute(characterId);

        assertThat(result).isNotNull();
        assertThat(result.get().getFirstName()).isEqualTo("SpongeBob");
        assertThat(result.get().getLastName()).isEqualTo("SquarePants");
        assertThat(result.get().getOccupation()).isEqualTo("Fry Cook");
        assertThat(result.get().getMotto()).isEqualTo("I’m ready!");
        assertThat(result.get().getImageUrl()).isEqualTo("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");
    }

    @Test
    public void givenInvalidCharacterId_whenGetCharacterById_thenReturnNull() {
        when(characterRepository.getCharacterById(anyString())).thenReturn(Optional.empty());

        var result = getCharacterByIdUseCase.execute("invalid-id");

        assertThat(result).isEmpty();
    }
}
