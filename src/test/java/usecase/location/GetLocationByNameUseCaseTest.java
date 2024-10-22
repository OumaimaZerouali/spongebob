package usecase.location;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import repository.location.LocationJPAEntity;
import repository.location.LocationRepository;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetLocationByNameUseCaseTest {
    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private GetLocationByNameUseCase getLocationByNameUseCase;

    @Test
    public void givenLocationWithName_whenGetLocationByName_thenReturnLocation() {
        var name = "Spongebob house";

        LocationJPAEntity entity = new LocationJPAEntity();
        entity.setId("id");
        entity.setName(name);
        entity.setAddress("124 Conch Street");
        entity.setDescription("Ananas house");
        entity.setOwner("Spongebob SquarePants");
        entity.setFunFact("Fun Fact");
        entity.setImageUrl("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");

        when(locationRepository.getLocationByName(name)).thenReturn(Optional.of(entity));

        var result = getLocationByNameUseCase.execute(name);

        assertThat(result).isNotNull();
        assertThat(result.get().getName()).isEqualTo("Spongebob house");
        assertThat(result.get().getAdress()).isEqualTo("124 Conch Street");
        assertThat(result.get().getDescription()).isEqualTo("Ananas house");
        assertThat(result.get().getOwner()).isEqualTo("Spongebob SquarePants");
        assertThat(result.get().getFunFact()).isEqualTo("Fun Fact");
        assertThat(result.get().getImageUrl()).isEqualTo("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");
    }

    @Test
    public void givenInvalidLocationName_whenGetLocationByName_thenReturnNull() {
        when(locationRepository.getLocationByName("FAKE")).thenReturn(Optional.empty());

        var result = getLocationByNameUseCase.execute("FAKE");

        assertThat(result).isEmpty();
    }

}