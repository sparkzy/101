import { Component, OnInit } from '@angular/core';
import { Flashcard } from '../../beans/flashcard';
import { FlashcardSet } from '../../beans/flashcardSet';
import { Subject } from '../../beans/subject';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-flashcard-set',
  templateUrl: './flashcard-set.component.html',
  styleUrls: ['./flashcard-set.component.css']
})
export class FlashcardSetComponent implements OnInit {

  newFlashcards: Array<Flashcard> = [];
  subjects: Array<Subject>;
  newSet: FlashcardSet = new FlashcardSet;

  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
    console.log(JSON.parse(this.cookie.get('user')).userId);
    this.client.get(`${environment.context}/subjects`)
      .subscribe(
        (succ: any) => {
          this.subjects = succ;
        }
      );
  }

  addNewFlashcard() {
    this.newFlashcards.push(new Flashcard(0, 0, '', '', JSON.parse(this.cookie.get('user')).userId));
  }

}
