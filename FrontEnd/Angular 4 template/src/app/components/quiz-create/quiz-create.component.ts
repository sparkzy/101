import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { Quiz } from '../../beans/quiz';
import { Subject } from '../../beans/subject';
import { environment } from '../../../environments/environment';
import { Question } from '../../beans/question';

@Component({
  selector: 'app-quiz-create',
  templateUrl: './quiz-create.component.html',
  styleUrls: ['./quiz-create.component.css']
})
export class QuizCreateComponent implements OnInit {

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  newQuestions: Array<Question> = [];
  subjects: Array<Subject>;
  newQuiz: Quiz = new Quiz;

  ngOnInit() {
    this.client.get(`${environment.context}/subjects`)
      .subscribe(
        (succ: any) => {
          this.subjects = succ;
        }
      );
  }

  addNewQuestion() {
    this.newQuestions.push(new Question(0, new Quiz, '', '', '', '', ''));
  }

  removeNewQuestion() {
    this.newQuestions.pop();
  }

  addNewQuiz() {
    this.newQuiz.author = JSON.parse(this.cookie.get('user'));
    this.client.post(`${environment.context}/quizzes`, this.newQuiz)
      .subscribe(
        (succ: any) => {
          this.newQuiz = succ;
          this.newQuestions.forEach(element => {
            element.quiz = this.newQuiz;
            this.postQuestion(element);
            this.router.navigateByUrl('quiz/view');
          },
            (err) => {
              alert('Failed to create set');
            }
          );
        });
  }

  postQuestion(question: Question) {
    this.client.post(`${environment.context}/questions`, question)
      .subscribe(
        (succ: any) => {
        },
        (err) => {
          alert('Failed to add question');
        }
      );
  }
}
