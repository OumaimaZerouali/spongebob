import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Quiz {
  question: string;
  answerOptions: string[];
  correctAnswer: string;
  hasAnswered: boolean;
  selectedAnswer?: string;
}

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  private apiUrl = 'http://localhost:8080/quiz';

  constructor(private http: HttpClient) {}

  createQuiz(): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(this.apiUrl);
  }
}
