import { Component, OnInit } from '@angular/core';
import { Quiz, QuizService } from "./service/quiz-service";
import { MatCheckboxModule } from '@angular/material/checkbox';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-quiz',
  standalone: true,
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.scss'],
  imports: [
    MatCheckboxModule,
    FormsModule
  ]
})
export class QuizComponent implements OnInit {
  quizzes: Quiz[] = [];
  newQuiz: Quiz[] = [];
  score: number = 0;

  constructor(private quizService: QuizService) {}

  ngOnInit(): void {
    this.createNewQuiz();
  }

  createNewQuiz(): void {
    this.quizService.createQuiz()
      .subscribe(
        (quiz) => {
          this.newQuiz = quiz;
          this.quizzes.push(...quiz);
        },
        (error) => {
          console.error('Error creating quiz:', error);
        }
      );
  }

  checkAnswer(quiz: Quiz, selectedOption: string): void {
    if (!quiz.hasAnswered) {
      quiz.selectedAnswer = selectedOption;
      quiz.hasAnswered = true;

      if (quiz.selectedAnswer === quiz.correctAnswer) {
        this.score++;
      }
    }
  }

  allQuestionsAnswered(): boolean {
    return this.quizzes.every(quiz => quiz.hasAnswered);
  }

  trackQuiz(index: number, quiz: Quiz): string {
    return quiz.question;
  }

  trackOption(index: number, option: string): string {
    return option;
  }
}
