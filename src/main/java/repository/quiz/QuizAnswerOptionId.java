package repository.quiz;

import java.io.Serializable;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class QuizAnswerOptionId implements Serializable {
    private String quizId;
    private String answerOption;

    public QuizAnswerOptionId() {}

    public QuizAnswerOptionId(String quizId, String answerOption) {
        this.quizId = quizId;
        this.answerOption = answerOption;
    }
}

