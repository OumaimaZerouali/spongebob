package controller.character;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import domain.character.Character;
import usecase.character.*;

import java.util.List;

@Path("/characters")
public class CharacterController {


    @Inject
    GetCharacterByIdUseCase getCharacterByIdUseCase;
    @Inject
    GetAllCharactersUseCase getAllCharactersUseCase;
    @Inject
    GetCharacterByNameUseCase getCharacterByNameUseCase;
    @Inject
    DeleteCharacterByNameUseCase deleteCharacterByNameUseCase;
    @Inject
    DeleteCharacterByIdUseCase deleteCharacterByIdUseCase;
    @Inject
    CreateOrUpdateCharacterUseCase createOrUpdateCharacterUseCase;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Character getCharacterById(@PathParam("id") String id) {
        return getCharacterByIdUseCase.execute(id);
    }

    @GET
    @Path("/{firstName}/{lastName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Character getCharacterByName(
            @PathParam("firstName") String firstName,
            @PathParam("lastName") String lastName) {
        return getCharacterByNameUseCase.execute(firstName, lastName);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Character> getAllCharacters() {
        return getAllCharactersUseCase.execute();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrUpdate(Character character) {
        createOrUpdateCharacterUseCase.execute(character);
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("{id}")
    public void deleteCharacter(@PathParam("id") String id) {
        deleteCharacterByIdUseCase.execute(id);
    }

    @DELETE
    @Path("/{firstName}/{lastName}")
    public void deleteCharacterByName(
            @PathParam("firstName") String firstName,
            @PathParam("lastName") String lastName) {
        deleteCharacterByNameUseCase.execute(firstName, lastName);
    }
}
