import { Component, OnInit } from '@angular/core';
import { Quiz } from '../../beans/quiz';
import { Question } from '../../beans/question';
import { HttpClient } from '@angular/common/http';
import { DynamicSortService } from '../../services/dynamic-sort.service';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment';
import { QuizTrackerService } from '../../services/quiz-tracker.service';

@Component({
  selector: 'app-quiz-take',
  templateUrl: './quiz-take.component.html',
  styleUrls: ['./quiz-take.component.css']
})
export class QuizTakeComponent implements OnInit {

  quiz: Quiz;
  questions: Array<Question>;
  idx = 0;
  userId: number = JSON.parse(this.cookie.get('user')).userId;
  authorId: number;
  quizId: number;
  ans: string;

  constructor(private client: HttpClient, private sorter: DynamicSortService,
    private cookie: CookieService, private router: Router, private quizTracker: QuizTrackerService) { }

  ngOnInit() {
    this.quizId = parseInt(this.router.url.substring(this.router.url.lastIndexOf('/') + 1), 10);
    this.quizTracker.quizId = parseInt(this.router.url.substring(this.router.url.lastIndexOf('/') + 1), 10);
    this.client.get(`${environment.context}quizzes/id/${this.quizId}`)
      .subscribe(
        (succ: any) => {
          this.quiz = succ;
          this.authorId = this.quiz.author.userId;
        },
        (err: any) => {
          this.router.navigateByUrl('quiz/view');
        }
      );
    this.client.get(`${environment.context}questions/quiz/id/${this.quizId}`)
      .subscribe(
        (succ: any) => {
          this.questions = succ;
        },
        (err: any) => {
        }
      );
  }

  next() {
    this.idx++;
    if (this.idx === this.questions.length) {
      this.idx = 0;
    }
    this.ans = undefined;
  }

  prev() {
    this.idx--;
    if (this.idx === -1) {
      this.idx = this.questions.length - 1;
    }
    this.ans = undefined;
  }

  like() {
    this.quiz.likes++;
    this.client.put(`${environment.context}quizzes`, this.quiz)
      .subscribe(
        (succ: any) => { },
        (err: any) => {
          alert('fialed to like quiz');
        }
      );
  }

  answer(ans: string) {
    this.ans = ans;
  }

  delete() {
    if (this.userId !== this.authorId) {
      return;
    } else {
      this.client.delete(`${environment.context}quizzes/id/${this.quizId}`)
        .subscribe(
          (succ: any) => {
          },
          (err: any) => {
            // alert('failed to delete');
          }
        );
      this.questions.forEach(q => {
        this.client.delete(`${environment.context}questions/id/${q.questionId}`)
          .subscribe(
            (succ: any) => {
            },
            (err: any) => {
              // alert('failed to delete fcs');
            }
          );
      });
      this.router.navigateByUrl('quiz/view');
    }
  }

  share() {

  }

  edit() {
    this.router.navigateByUrl('quiz/update');
  }

}
