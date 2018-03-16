import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../beans/quiz';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../../beans/user';

@Component({
  selector: 'app-quiz-delete',
  templateUrl: './quiz-delete.component.html',
  styleUrls: ['./quiz-delete.component.css']
})
export class QuizDeleteComponent implements OnInit {

  quizzes: Array<Quiz> = [];
  authorCookie: User;
  newQuiz: Quiz = new Quiz;

  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
    this.client.get(`${environment.context}quizzes`)
      .subscribe(
        (succ: Array<Quiz>) => {
          this.quizzes = succ;
        },
        (err) => {
          console.log('Failed to load quizzes.');
        }
      );
  }

}
