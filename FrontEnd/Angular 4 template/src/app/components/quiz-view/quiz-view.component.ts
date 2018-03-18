import { Component, OnInit } from '@angular/core';
import { Subject } from '../../beans/subject';
import { Quiz } from '../../beans/quiz';
import { HttpClient } from '@angular/common/http';
import { DynamicSortService } from '../../services/dynamic-sort.service';
import { Router } from '@angular/router';
import { SetTrackerService } from '../../services/set-tracker.service';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-quiz-view',
  templateUrl: './quiz-view.component.html',
  styleUrls: ['./quiz-view.component.css']
})
export class QuizViewComponent implements OnInit {

  subjects: Array<Subject>;
  quizzes: Array<Quiz>;
  titleFilter: string;
  authorFilter: string;
  subjectFilter: string;

  constructor(private client: HttpClient, private sorter: DynamicSortService, private router: Router,
    private setTracker: SetTrackerService) { }


    ngOnInit() {
      this.client.get(`${environment.context}/quizzes/`)
        .subscribe(
          (succ: any) => {
            this.quizzes = succ;
          },
          (err: any) => {
            alert('Failed to get quizes');
          }
        );
      this.client.get(`${environment.context}/subjects`)
        .subscribe(
          (succ: any) => {
            this.subjects = succ;
          },
          (err: any) => {
            alert('Failed to get subjects');
          }
        );
    }

    sort(property: string) {
      this.sorter.arraySort(this.quizzes, property);
    }

    sortBySubject(subject: string) {
      let sortOrder = 1;
      if (subject[0] === '-') {
        sortOrder = -1;
        subject = subject.substr(1);
      }
      return function (a: Quiz, b: Quiz) {
        const result = (a.subject[subject] < b.subject[subject]) ? -1 : (a.subject[subject] > b.subject[subject]) ? 1 : 0;
        return result * sortOrder;
      };
    }

    sortByAuthor(username: string) {
      let sortOrder = 1;
      if (username[0] === '-') {
        sortOrder = -1;
        username = username.substr(1);
      }
      return function (a: Quiz, b: Quiz) {
        const result = (a.author[username] < b.author[username]) ? -1 : (a.author[username] > b.author[username]) ? 1 : 0;
        return result * sortOrder;
      };
    }

    sortArray(func: Function, property: string) {
      this.quizzes.sort(func(property));
    }

    view(quiz: Quiz) {
      // this.setTracker.setId = set.fcSetId;
      this.router.navigateByUrl(`quiz/take/${quiz.quizId}`);
    }

    like(quiz: Quiz) {
      quiz.likes++;
      this.client.put(`${environment.context}quizzes`, quiz)
        .subscribe(
          (succ: any) => { this.router.navigateByUrl('quiz/view'); },
          (err: any) => {
          }
        );
    }

}
