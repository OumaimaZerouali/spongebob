package repository.location;

import com.speedment.jpastreamer.application.JPAStreamer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class LocationRepositoryTest {

    @Mock
    JPAStreamer jpaStreamer;

    @InjectMocks
    LocationRepository locationRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void givenLocationName_whenGetLocationByName_thenReturnLocation() {
        String name = "SpongeBob house";

        LocationJPAEntity entity = new LocationJPAEntity();
        entity.setId(UUID.randomUUID().toString());
        entity.setName(name);

        when(jpaStreamer.stream(LocationJPAEntity.class)).thenReturn(Stream.of(entity));

        var location = locationRepository.getLocationByName(name);

        assertThat(location).isNotNull();
        assertThat(location.getName()).isEqualTo(name);
    }

}