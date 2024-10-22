package usecase.quiz;

import domain.quiz.Quiz;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import repository.quiz.QuizJPAEntity;
import repository.quiz.QuizRepository;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CreateANewQuizUseCase {

    @Inject
    QuizRepository quizRepository;

    @Transactional
    public List<Quiz> createQuiz() {
        List<QuizJPAEntity> randomQuestions = quizRepository.getRandomQuizzes(7);
        List<Quiz> quizList = new ArrayList<>();

        for (QuizJPAEntity quizEntity : randomQuestions) {
            List<String> answerOptions = getAnswerOptionsForQuiz(quizEntity.getId()); // Fetch answer options from the repository or other source
            String correctAnswer = quizEntity.getAnswer(); // Assuming your entity has the correct answer

            // Create a new Quiz object for each question
            Quiz quiz = new Quiz(quizEntity.getQuestion(), answerOptions, correctAnswer);
            quizList.add(quiz);
        }

        return quizList; // Return the list of created Quiz objects
    }

    private List<String> getAnswerOptionsForQuiz(String quizId) {
        return quizRepository.getAnswerOptionsForQuiz(quizId);
    }
}
