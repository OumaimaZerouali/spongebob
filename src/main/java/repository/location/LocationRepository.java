package repository.location;

import com.speedment.jpastreamer.application.JPAStreamer;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class LocationRepository {

    @Inject
    JPAStreamer jpaStreamer;

    public Optional<LocationJPAEntity> getLocationByName(String name) {
        return jpaStreamer.stream(LocationJPAEntity.class)
                .filter(locationJPAEntity ->
                        locationJPAEntity.getName().equals(name))
                .findFirst();
    }
}
