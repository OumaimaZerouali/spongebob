package usecase.location;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.location.LocationJPAEntity;
import repository.location.LocationRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class GetLocationByNameUseCaseTest {
    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private GetLocationByNameUseCase getLocationByNameUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

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

        when(locationRepository.getLocationByName(name)).thenReturn(entity);

        var result = getLocationByNameUseCase.execute(name);

        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo("Spongebob house");
        assertThat(result.getAdress()).isEqualTo("124 Conch Street");
        assertThat(result.getDescription()).isEqualTo("Ananas house");
        assertThat(result.getOwner()).isEqualTo("Spongebob SquarePants");
        assertThat(result.getFunFact()).isEqualTo("Fun Fact");
        assertThat(result.getImageUrl()).isEqualTo("https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");
    }

    @Test
    public void givenInvalidLocationName_whenGetLocationByName_thenReturnNull() {
        when(locationRepository.getLocationByName("FAKE")).thenReturn(null);

        var result = getLocationByNameUseCase.execute("FAKE");

        assertThat(result).isNull();
    }

}