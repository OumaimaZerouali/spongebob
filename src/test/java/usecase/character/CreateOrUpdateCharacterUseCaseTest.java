package usecase.character;

import domain.character.Character;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.character.CharacterJPAEntity;
import repository.character.CharacterRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreateOrUpdateCharacterUseCaseTest {

    @Mock
    private CharacterRepository characterRepository;

    @InjectMocks
    private CreateOrUpdateCharacterUseCase createOrUpdateCharacterUseCase;

    @Test
    public void givenExistingCharacter_whenExecute_thenUpdateCharacter() {
        Character character = new Character("SpongeBob", "SquarePants", "Fry Cook", "I’m ready!", "imageUrl");

        CharacterJPAEntity existingCharacter = new CharacterJPAEntity();
        existingCharacter.setFirstname("SpongeBob");
        existingCharacter.setLastname("SquarePants");
        existingCharacter.setOccupation("Old Occupation");
        existingCharacter.setMotto("Old Motto");
        existingCharacter.setImageurl("Old ImageUrl");

        when(characterRepository.getCharacterByName(character.getFirstName(), character.getLastName())).thenReturn(Optional.of(existingCharacter));

        createOrUpdateCharacterUseCase.execute(character);

        assertThat(existingCharacter.getOccupation()).isEqualTo("Fry Cook");
        assertThat(existingCharacter.getMotto()).isEqualTo("I’m ready!");
        assertThat(existingCharacter.getImageurl()).isEqualTo("imageUrl");
        verify(characterRepository).updateCharacter(existingCharacter);
    }

    @Test
    public void givenNewCharacter_whenExecute_thenCreateCharacter() {
        Character character = new Character("New", "Character", "New Occupation", "New Motto", "newImageUrl");

        when(characterRepository.getCharacterByName(character.getFirstName(), character.getLastName())).thenReturn(Optional.empty());

        createOrUpdateCharacterUseCase.execute(character);

        verify(characterRepository).createCharacter(character);
        verify(characterRepository, never()).updateCharacter(any());
    }
}
