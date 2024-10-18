package domain.quiz;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@EqualsAndHashCode
public class Quiz {
    private String question;
    private List<String> answerOptions;
    private String correctAnswer;

    public Quiz(String question, List<String> answerOptions, String correctAnswer) {
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
    }
}
