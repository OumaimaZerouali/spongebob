package repository.quiz;

import domain.quiz.Quiz;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "quiz")
@NoArgsConstructor
public class QuizJPAEntity {

    @Id
    @Column(name = "id")
    @EqualsAndHashCode.Include
    private String id;

    @Column(name = "question")
    private String question;

    @ElementCollection
    @CollectionTable(name = "quiz_answer_options", joinColumns = @JoinColumn(name = "quiz_id"))
    @Column(name = "answer_option")
    private List<String> answerOptions;

    @Column(name = "answer")
    private String answer;

    public QuizJPAEntity(Quiz quiz) {
        this.id = UUID.randomUUID().toString();
        this.question = quiz.getQuestion();
        this.answerOptions = quiz.getAnswerOptions();
        this.answer = quiz.getCorrectAnswer();
    }
}
