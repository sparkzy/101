import { Component, OnInit } from '@angular/core';
import { Question } from '../../beans/question';
import { Subject } from '../../beans/subject';
import { Quiz } from '../../beans/quiz';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { environment } from '../../../environments/environment';
import { QuizTrackerService } from '../../services/quiz-tracker.service';

@Component({
  selector: 'app-quiz-update',
  templateUrl: './quiz-update.component.html',
  styleUrls: ['./quiz-update.component.css']
})
export class QuizUpdateComponent implements OnInit {

  newQuestions: Array<Question> = [];
  subjects: Array<Subject>;
  questions: Array<Question>;
  quiz: Quiz = new Quiz;
  userId: number = JSON.parse(this.cookie.get('user')).userId;
  authorId: number;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router,
    private quizTracker: QuizTrackerService) { }

  ngOnInit() {
    console.log(this.quizTracker.quizId);
    this.client.get(`${environment.context}subjects`)
      .subscribe(
        (succ: any) => {
          this.subjects = succ;
        }
      );
    this.client.get(`${environment.context}questions/quiz/id/${this.quizTracker.quizId}`)
      .subscribe(
        (succ: any) => {
          this.questions = succ;
        }
      );
    this.client.get(`${environment.context}quizzes/id/${this.quizTracker.quizId}`)
      .subscribe(
        (succ: any) => {
          this.quiz = succ;
          this.authorId = this.quiz.author.userId;
        }
      );
  }

  addNewQuestion() {
    this.newQuestions.push(new Question(0, this.quiz, '', '', '', '', ''));
  }

  removeNewQuestion() {
    this.newQuestions.pop();
  }

  updateQuiz() {
    this.quiz.quizId = this.quizTracker.quizId;
    this.quiz.author = JSON.parse(this.cookie.get('user'));
    this.client.post(`${environment.context}quizzes`, this.quiz)
      .subscribe(
        (succ: any) => {
          this.quiz = succ;
          this.newQuestions.forEach(element => {
            element.quiz = this.quiz;
            this.postFc(element);
            this.router.navigateByUrl('quiz/view');
          }
          );
        });
  }

  postFc(q: Question) {
    this.client.post(`${environment.context}/questions`, q)
      .subscribe(
        (succ: any) => {
        },
        (err) => {
          alert('Failed to add question');
        }
      );
  }

  checkSubmit() {
    let bool = false;
    if (this.quiz.title === '' || this.quiz.subject.id === 0) {
      bool = true;
    } else {
      this.newQuestions.forEach(element => {
        if (element.correctAnswer === '' || element.wrongAnswer1 === '' || element.question === '') {
          bool = true;
        }
      });
    }
    return bool;
  }

  deleteFc(qId: number) {
    // this.setTracker.setId = this.set.fcSetId;
    if (this.userId !== this.authorId) {
      return;
    } else {
      this.client.delete(`${environment.context}questions/id/${qId}`)
        .subscribe(
          (succ: any) => {
          },
          (err: any) => {
            // alert('failed to delete');
          }
        );
    }
  }

  delete() {
    if (this.userId !== this.authorId) {
      return;
    } else {
      this.client.delete(`${environment.context}quizzes/id/${this.quizTracker.quizId}`)
        .subscribe(
          (succ: any) => {

          },
          (err: any) => {
            alert('failed to delete');
          }
        );
      this.questions.forEach(q => {
        this.client.delete(`${environment.context}questions/id/${q.questionId}`)
          .subscribe(
            (succ: any) => {

            },
            (err: any) => {
              alert('failed to delete fcs');
            }
          );
      });
      this.router.navigateByUrl('quiz/view');
    }
  }

}
