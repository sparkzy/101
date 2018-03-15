import { Component, OnInit } from '@angular/core';
import { Flashcard } from '../../beans/flashcard';
import { FlashcardSet } from '../../beans/flashcardSet';
import { Subject } from '../../beans/subject';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flashcard-set',
  templateUrl: './flashcard-set-create.component.html',
  styleUrls: ['./flashcard-set-create.component.css']
})
export class FlashcardSetCreateComponent implements OnInit {

  newFlashcards: Array<Flashcard> = [];
  subjects: Array<Subject>;
  newSet: FlashcardSet = new FlashcardSet;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
    this.client.get(`${environment.context}/subjects`)
      .subscribe(
        (succ: any) => {
          this.subjects = succ;
        }
      );
  }

  addNewFlashcard() {
    this.newFlashcards.push(new Flashcard(0, 0, new FlashcardSet, '', '', JSON.parse(this.cookie.get('user'))));
  }

  removeNewFlashcard() {
    this.newFlashcards.pop();
  }

  addNewSet() {
    this.newSet.author = JSON.parse(this.cookie.get('user'));
    this.client.post(`${environment.context}/sets`, this.newSet)
      .subscribe(
        (succ: any) => {
          this.newSet = succ;
          this.newFlashcards.forEach(element => {
            element.fcSet = this.newSet;
            element.author = this.newSet.author;
            this.postFc(element);
          }
          );
        });
        this.router.navigateByUrl('flashcards/view');
  }

  postFc(fc: Flashcard) {
    this.client.post(`${environment.context}/flashcards`, fc)
      .subscribe(
        (succ: any) => {
          console.log('added fc');
        },
        (err) => {
          alert('Failed to add flashcard');
        }
      );
  }

  checkSubmit() {
    let bool = false;
    if (this.newSet.title === '' || this.newSet.subject.id === 0 ) {
      bool = true;
    } else {
      this.newFlashcards.forEach(element => {
        if (element.answer === '' || element.question === '') {
          bool = true;
        }
      });
    }
    return bool;
  }

}
