import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { FlashcardSet } from '../../beans/flashcardSet';
import { environment } from '../../../environments/environment';
import { Subject } from '../../beans/subject';
import { User } from '../../beans/user';

@Component({
  selector: 'app-flashcard-set-search',
  templateUrl: './flashcard-set-search.component.html',
  styleUrls: ['./flashcard-set-search.component.css']
})
export class FlashcardSetSearchComponent implements OnInit {

  flashcardSets: FlashcardSet;
  subjects: any;

  newFcSet: FlashcardSet = {
    fcSetId: 0,
    subject: new Subject,
    title: '',
    likes: 0,
    author: new User
  };

  constructor(private client: HttpClient) { }

  ngOnInit() {
    this.client.get(`${environment.context}subjects`)
      .subscribe(
        (succ: any) => {
          this.subjects = succ;
          console.log(this.subjects);
        },
        (err) => {
          alert('failed to get any subjects');
        }
      );
  }

  searchSet(set: FlashcardSet): void {
    this.client.get(`${environment.context}sets/title/${this.newFcSet.title}`)
      .subscribe(
        (succ: any) => {
          this.flashcardSets = succ;
        },
        (err) => {
          alert('Failed to find any sets');
        }
      );
  }

}
