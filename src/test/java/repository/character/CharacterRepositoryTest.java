package repository.character;

import com.speedment.jpastreamer.application.JPAStreamer;
import domain.character.Character;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CharacterRepositoryTest {

    @Mock
    JPAStreamer jpaStreamer;

    @Mock
    EntityManager entityManager;

    @InjectMocks
    CharacterRepository characterRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenCharacterId_whenGetCharacterById_thenReturnCharacter() {
        String characterId = UUID.randomUUID().toString();
        CharacterJPAEntity character = new CharacterJPAEntity();
        character.setId(characterId);
        character.setFirstname("SpongeBob");
        character.setLastname("SquarePants");

        when(jpaStreamer.stream(CharacterJPAEntity.class)).thenReturn(Stream.of(character));

        CharacterJPAEntity foundCharacter = characterRepository.getCharacterById(characterId);

        assertThat(foundCharacter).isNotNull();
        assertThat(foundCharacter.getId()).isEqualTo(characterId);
        assertThat(foundCharacter.getFirstname()).isEqualTo("SpongeBob");
        assertThat(foundCharacter.getLastname()).isEqualTo("SquarePants");
    }

    @Test
    void givenFirstNameAndLastName_whenGetCharacterByName_thenReturnCharacter() {
        String firstName = "SpongeBob";
        String lastName = "SquarePants";
        CharacterJPAEntity character = new CharacterJPAEntity();
        character.setId(UUID.randomUUID().toString());
        character.setFirstname(firstName);
        character.setLastname(lastName);

        when(jpaStreamer.stream(CharacterJPAEntity.class)).thenReturn(Stream.of(character));

        CharacterJPAEntity foundCharacter = characterRepository.getCharacterByName(firstName, lastName);

        assertThat(foundCharacter).isNotNull();
        assertThat(foundCharacter.getFirstname()).isEqualTo(firstName);
        assertThat(foundCharacter.getLastname()).isEqualTo(lastName);
    }

    @Test
    void whenGetCharacters_thenReturnListOfCharacters() {
        CharacterJPAEntity character1 = new CharacterJPAEntity();
        character1.setId(UUID.randomUUID().toString());
        character1.setFirstname("SpongeBob");
        character1.setLastname("SquarePants");

        CharacterJPAEntity character2 = new CharacterJPAEntity();
        character2.setId(UUID.randomUUID().toString());
        character2.setFirstname("Patrick");
        character2.setLastname("Star");

        when(jpaStreamer.stream(CharacterJPAEntity.class)).thenReturn(Stream.of(character1, character2));

        List<CharacterJPAEntity> characters = characterRepository.getCharacters();

        assertThat(characters).hasSize(2);
        assertThat(characters).extracting(CharacterJPAEntity::getFirstname).containsExactlyInAnyOrder("SpongeBob", "Patrick");
    }

    @Test
    void givenCharacter_whenCreateCharacter_thenPersistCharacter() {
        Character character = new Character("SpongeBob", "SquarePants", "Fry Cook", "I’m ready!", "https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");

        characterRepository.createCharacter(character);

        verify(entityManager, times(1)).persist(any(CharacterJPAEntity.class));
    }

    @Test
    void givenCharacterEntity_whenUpdateCharacter_thenMergeCharacter() {
        CharacterJPAEntity characterEntity = new CharacterJPAEntity();
        characterEntity.setId(UUID.randomUUID().toString());
        characterEntity.setFirstname("SpongeBob");
        characterEntity.setLastname("SquarePants");

        characterRepository.updateCharacter(characterEntity);

        verify(entityManager, times(1)).merge(characterEntity);
    }

    @Test
    void givenCharacterId_whenDeleteCharacter_thenRemoveCharacter() {
        String characterId = UUID.randomUUID().toString();
        CharacterJPAEntity character = new CharacterJPAEntity();
        character.setId(characterId);

        when(entityManager.find(CharacterJPAEntity.class, characterId)).thenReturn(character);

        characterRepository.deleteCharacter(characterId);

        verify(entityManager, times(1)).remove(character);
    }

    @Test
    void givenNonExistentCharacterId_whenDeleteCharacter_thenDoNotRemoveCharacter() {
        String characterId = UUID.randomUUID().toString();

        when(entityManager.find(CharacterJPAEntity.class, characterId)).thenReturn(null);

        characterRepository.deleteCharacter(characterId);

        verify(entityManager, times(0)).remove(any());
    }
}

