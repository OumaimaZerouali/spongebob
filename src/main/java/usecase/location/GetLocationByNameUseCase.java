package usecase.location;

import domain.location.Location;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.location.LocationRepository;

@ApplicationScoped
public class GetLocationByNameUseCase {

    @Inject
    LocationRepository locationRepository;

    public Location execute(String name){
        var locationEntity = locationRepository.getLocationByName(name);

        if(locationEntity == null){
            return null;
        }

        return new Location(
                locationEntity.getName(),
                locationEntity.getDescription(),
                locationEntity.getOwner(),
                locationEntity.getFunFact(),
                locationEntity.getAddress(),
                locationEntity.getImageUrl()
        );
    }
}
