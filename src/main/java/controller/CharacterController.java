package controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import usecase.CreateOrUpdateCharacterUseCase;
import usecase.DeleteCharacterUseCase;
import usecase.GetAllCharactersUseCase;
import domain.Character;
import usecase.GetCharacterByIdUseCase;

import java.util.List;

@Path("/characters")
public class CharacterController {

    @Inject
    DeleteCharacterUseCase deleteCharacterUseCase;
    @Inject
    GetCharacterByIdUseCase getCharacterByIdUseCase;
    @Inject
    GetAllCharactersUseCase getAllCharactersUseCase;
    @Inject
    CreateOrUpdateCharacterUseCase createOrUpdateCharacterUseCase;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Character getCharacterById(@PathParam("id") String id) {
        return getCharacterByIdUseCase.execute(id);
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
        deleteCharacterUseCase.execute(id);
    }
}
