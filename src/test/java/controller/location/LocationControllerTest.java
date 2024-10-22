package controller.location;

import domain.location.Location;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import usecase.location.GetLocationByNameUseCase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@QuarkusTest
class LocationControllerTest {

    @InjectMock
    GetLocationByNameUseCase getLocationByNameUseCase;

    @Test
    public void givenValidLocationName_whenGetLocationByName_thenReturnLocation() throws IOException {
        var name = "Spongebob house";

        when(getLocationByNameUseCase.execute(name))
                .thenReturn(Optional.of(
                        new Location(name, "A ananas house", "Spongebob SquarePants", "FUN FACT", "124 Conch street", "https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png")
                ));

        var response = readResourceFile("location.json");

        given().when()
                .contentType("application/json")
                .get("/locations/{name}", name)
                .then()
                .statusCode(200)
                .body(is(response));
    }


    private String readResourceFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getPath())));
    }
}