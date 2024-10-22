package usecase.location;

import domain.location.Location;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.location.LocationRepository;

import java.util.Optional;

@ApplicationScoped
public class GetLocationByNameUseCase {

    @Inject
    LocationRepository locationRepository;

    public Optional<Location> execute(String name){
        return locationRepository.getLocationByName(name).map(
                entity -> new Location(
                        entity.getName(),
                        entity.getDescription(),
                        entity.getOwner(),
                        entity.getFunFact(),
                        entity.getAddress(),
                        entity.getImageUrl()
                )
        );
    }
}
