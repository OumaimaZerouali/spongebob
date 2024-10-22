package repository.quiz;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "quiz_answer_options")
@NoArgsConstructor
@EqualsAndHashCode
@IdClass(QuizAnswerOptionId.class)  // Use IdClass for composite key
public class QuizAnswerOptionJPAEntity {

    @Id
    @Column(name = "quiz_id", nullable = false)
    private String quizId;

    @Id
    @Column(name = "answer_option", nullable = false)
    private String answerOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id", insertable = false, updatable = false)
    private QuizJPAEntity quiz;

    public QuizAnswerOptionJPAEntity(String answerOption, QuizJPAEntity quiz) {
        this.answerOption = answerOption;
        this.quizId = quiz.getId();
        this.quiz = quiz;
    }
}

