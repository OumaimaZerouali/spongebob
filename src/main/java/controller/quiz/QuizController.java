package controller.quiz;

import domain.quiz.Quiz;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import usecase.quiz.CreateANewQuizUseCase;

import java.util.List;

@Path("/quiz")
public class QuizController {

    @Inject
    CreateANewQuizUseCase createANewQuizUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getQuizzes() {
        List<Quiz> newQuiz = createANewQuizUseCase.createQuiz();
        return Response.ok(newQuiz).build();
    }
}
