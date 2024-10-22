package controller.character;

import domain.character.Character;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import usecase.character.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@QuarkusTest
class CharacterControllerTest {

    @InjectMock
    DeleteCharacterByIdUseCase deleteCharacterByIdUseCase;

    @InjectMock
    GetCharacterByIdUseCase getCharacterByIdUseCase;

    @InjectMock
    GetAllCharactersUseCase getAllCharactersUseCase;

    @InjectMock
    GetCharacterByNameUseCase  getCharacterByNameUseCase;

    @InjectMock
    DeleteCharacterByNameUseCase deleteCharacterByNameUseCase;

    @InjectMock
    CreateOrUpdateCharacterUseCase createOrUpdateCharacterUseCase;

    @Nested
    class GetAllCharacters {
        @Test
        public void givenCharacters_whenGetAllCharacters_thenReturnAllCharacters() throws IOException {
            when(getAllCharactersUseCase.execute()).thenReturn(List.of(
                    new Character("SpongeBob", "SquarePants", "Fry Cook", "I’m ready!", "https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png"),
                    new Character("Patrick", "Star", "Unemployed", "Is mayonnaise an instrument?", "https://example.com/patrick.jpg")
            ));

            String expectedResponse = readResourceFile("characters.json");

            given()
                    .contentType("application/json")
                    .when()
                    .get("/characters")
                    .then()
                    .statusCode(200)
                    .body(is(expectedResponse));
        }
    }

    @Nested
    class GetCharacter {
        @Test
        public void givenCharacterWithValidId_whenGetCharacterById_thenReturnCharacter() throws IOException {
            when(getCharacterByIdUseCase.execute(anyString()))
                    .thenReturn(Optional.of(
                            new Character("SpongeBob", "SquarePants", "Fry Cook", "I’m ready!", "https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png")
                    ));

            var response = readResourceFile("spongebob.json");

            given().when()
                    .contentType("application/json")
                    .get("/characters/b3158f8e-5e10-4e94-aaf2-3049e7a5e6a3")
                    .then()
                    .statusCode(200)
                    .body(is(response));
        }

        @Test
        public void givenValidCharacterWithName_whenGetCharacterByName_thenReturnCharacter() throws IOException {
            var firstName = "Spongebob";
            var lastName = "SquarePants";

            when(getCharacterByNameUseCase.execute(firstName, lastName))
                    .thenReturn(new Character(firstName, lastName, "Fry Cook", "I’m ready!", "https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png"));

            var response = readResourceFile("spongebob_2.json");

            given().when()
                    .contentType("application/json")
                    .get("/characters/{firstName}/{lastName}", firstName, lastName)
                    .then()
                    .statusCode(200)
                    .body(is(response));
        }
    }

    @Nested
    class CreateOrUpdateCharacter {
        @Test
        public void givenCharacter_whenCreateOrUpdateCharacter_thenShouldReturn201() {
            Character character = new Character("SpongeBob", "SquarePants", "Fry Cook", "I’m ready!", "https://upload.wikimedia.org/wikipedia/en/3/3b/SpongeBob_SquarePants_main_characters.png");

            doNothing().when(createOrUpdateCharacterUseCase).execute(any(Character.class));

            given()
                    .contentType("application/json")
                    .body(character)
                    .when()
                    .post("/characters")
                    .then()
                    .statusCode(Response.Status.CREATED.getStatusCode());

            Mockito.verify(createOrUpdateCharacterUseCase).execute(character);
        }
    }

    @Nested
    class DeleteCharacter {
        @Test
        public void givenCharacterId_whenDeleteCharacter_thenShouldDeleteCharacter() {
            String characterId = "b3158f8e-5e10-4e94-aaf2-3049e7a5e6a3";

            doNothing().when(deleteCharacterByIdUseCase).execute(characterId);

            given().when()
                    .delete("/characters/{id}", characterId)
                    .then()
                    .statusCode(Response.Status.NO_CONTENT.getStatusCode());

            Mockito.verify(deleteCharacterByIdUseCase).execute(characterId);
        }

        @Test
        public void givenValidCharacterWithName_whenDeleteCharacterByName_thenShouldDeleteCharacter() {
            var firstName = "Spongebob";
            var lastName = "SquarePants";

            doNothing().when(deleteCharacterByNameUseCase).execute(firstName, lastName);

            given().when()
                    .delete("/characters/{firstName}/{lastName}", firstName, lastName)
                    .then()
                    .statusCode(Response.Status.NO_CONTENT.getStatusCode());

            Mockito.verify(deleteCharacterByNameUseCase).execute(firstName, lastName);
        }
    }

    private String readResourceFile(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).getPath())));
    }
}
