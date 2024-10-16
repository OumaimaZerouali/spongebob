package usecase.character;

import domain.character.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.character.CharacterRepository;
import repository.character.CharacterJPAEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class GetAllCharactersUseCaseTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private GetAllCharactersUseCase getAllCharactersUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void givenCharactersInRepository_whenExecute_thenReturnAllCharacters() {
        CharacterJPAEntity character1 = new CharacterJPAEntity();
        character1.setFirstname("SpongeBob");
        character1.setLastname("SquarePants");
        character1.setOccupation("Fry Cook");
        character1.setMotto("I can't wait to be a fry cook!");

        CharacterJPAEntity character2 = new CharacterJPAEntity();
        character2.setFirstname("Patrick");
        character2.setLastname("Star");
        character2.setOccupation("Lifeguard");
        character2.setMotto("The inner machinations of my mind are an enigma.");

        List<CharacterJPAEntity> characterEntities = Arrays.asList(character1, character2);
        when(characterRepository.getCharacters()).thenReturn(characterEntities);

        List<Character> characters = getAllCharactersUseCase.execute();

        assertThat(characters).hasSize(2);
        assertThat(characters.get(0).getFirstName()).isEqualTo("SpongeBob");
        assertThat(characters.get(1).getFirstName()).isEqualTo("Patrick");
    }

    @Test
    public void givenNoCharactersInRepository_whenExecute_thenReturnEmptyList() {
        when(characterRepository.getCharacters()).thenReturn(List.of());

        List<Character> characters = getAllCharactersUseCase.execute();

        assertThat(characters).isEmpty();
    }
}
