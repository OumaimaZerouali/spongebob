package repository.quiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class QuizRepository {

    @Inject
    EntityManager entityManager;

    public List<QuizJPAEntity> getRandomQuizzes(int numberOfQuestions) {
        TypedQuery<QuizJPAEntity> query = entityManager.createQuery(
                "SELECT q FROM QuizJPAEntity q", QuizJPAEntity.class);
        List<QuizJPAEntity> allQuestions = query.getResultList();

        Collections.shuffle(allQuestions);
        return allQuestions.stream().limit(numberOfQuestions).collect(Collectors.toList());
    }

    public List<String> getAnswerOptionsForQuiz(String quizId) {
        TypedQuery<String> query = entityManager.createQuery(
                "SELECT qo.answerOption FROM QuizAnswerOptionJPAEntity qo WHERE qo.quizId = :quizId ORDER BY RANDOM()", String.class);
        query.setParameter("quizId", quizId);
        return query.getResultList();
    }
}
