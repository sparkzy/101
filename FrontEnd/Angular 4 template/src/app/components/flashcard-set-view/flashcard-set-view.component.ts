import { Component, OnInit } from '@angular/core';
import { Subject } from '../../beans/subject';
import { FlashcardSet } from '../../beans/flashcardSet';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-flashcard-set-view',
  templateUrl: './flashcard-set-view.component.html',
  styleUrls: ['./flashcard-set-view.component.css']
})
export class FlashcardSetViewComponent implements OnInit {

  subjects: Array<Subject>;
  sets: Array<FlashcardSet>;

  constructor(private client: HttpClient) { }

  ngOnInit() {
    this.client.get(`${environment.context}/sets`)
      .subscribe(
        (succ: any) => {
          this.sets = succ;
          console.log(this.sets);
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

  // view(set: FlashcardSet) {

  // }

}
