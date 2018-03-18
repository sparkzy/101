import { Component, OnInit } from '@angular/core';
import { Subject } from '../../beans/subject';
import { FlashcardSet } from '../../beans/flashcardSet';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { DynamicSortService } from '../../services/dynamic-sort.service';
import { Router } from '@angular/router';
import { SetTrackerService } from '../../services/set-tracker.service';

@Component({
  selector: 'app-flashcard-set-view',
  templateUrl: './flashcard-set-view.component.html',
  styleUrls: ['./flashcard-set-view.component.css']
})
export class FlashcardSetViewComponent implements OnInit {

  subjects: Array<Subject>;
  sets: Array<FlashcardSet>;
  titleFilter: string;
  authorFilter: string;
  subjectFilter: string;

  constructor(private client: HttpClient, private sorter: DynamicSortService, private router: Router,
    private setTracker: SetTrackerService) { }

  ngOnInit() {
    this.client.get(`${environment.context}/sets/status/banned`)
      .subscribe(
        (succ: any) => {
          this.sets = succ;
        },
        (err: any) => {
          alert('Failed to get sets');
        }
      );
    this.client.get(`${environment.context}/subjects`)
      .subscribe(
        (succ: any) => {
          this.subjects = succ;
        },
        (err: any) => {
          alert('Failed to get sets');
        }
      );
  }

  sort(property: string) {
    this.sorter.arraySort(this.sets, property);
  }

  sortBySubject(subject: string) {
    let sortOrder = 1;
    if (subject[0] === '-') {
      sortOrder = -1;
      subject = subject.substr(1);
    }
    return function (a: FlashcardSet, b: FlashcardSet) {
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
    return function (a: FlashcardSet, b: FlashcardSet) {
      const result = (a.author[username] < b.author[username]) ? -1 : (a.author[username] > b.author[username]) ? 1 : 0;
      return result * sortOrder;
    };
  }

  sortArray(func: Function, property: string) {
    this.sets.sort(func(property));
  }

  view(set: FlashcardSet) {
    this.setTracker.setId = set.fcSetId;
    this.router.navigateByUrl('flashcards/set');
  }

}
