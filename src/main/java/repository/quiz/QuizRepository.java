package repository.quiz;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class QuizRepository {

    @Inject
    EntityManager entityManager;

    public List<QuizJPAEntity> getAllQuizzes() {
        TypedQuery<QuizJPAEntity> query = entityManager.createQuery(
                "SELECT q FROM QuizJPAEntity q", QuizJPAEntity.class);
        return query.getResultList();
    }

    public QuizJPAEntity getQuizById(String quizId) {
        return entityManager.find(QuizJPAEntity.class, quizId);
    }
}
