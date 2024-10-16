package controller.location;

import domain.location.Location;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.WebApplicationException;
import usecase.location.GetLocationByNameUseCase;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Path("/locations")
public class LocationController {

    @Inject
    GetLocationByNameUseCase getLocationByNameUseCase;

    @GET
    @Path("/{name}")
    public Location getLocationByName(@PathParam("name") String name) {
        if (name == null) {
            throw new WebApplicationException("Location name is missing", 400);
        }

        String decodedName = URLDecoder.decode(name, StandardCharsets.UTF_8);
        return getLocationByNameUseCase.execute(decodedName);
    }
}
