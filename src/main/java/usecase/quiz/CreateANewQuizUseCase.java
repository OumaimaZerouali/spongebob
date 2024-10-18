package usecase.quiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import repository.quiz.QuizRepository;

@ApplicationScoped
public class CreateANewQuizUseCase {

    @Inject
    QuizRepository quizRepository;


}
