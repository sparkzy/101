import { Component, OnInit } from '@angular/core';
import { Flashcard } from '../../beans/flashcard';
import { Subject } from '../../beans/subject';
import { FlashcardSet } from '../../beans/flashcardSet';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { environment } from '../../../environments/environment';
import { SetTrackerService } from '../../services/set-tracker.service';

@Component({
  selector: 'app-flashcard-set-edit',
  templateUrl: './flashcard-set-edit.component.html',
  styleUrls: ['./flashcard-set-edit.component.css']
})
export class FlashcardSetEditComponent implements OnInit {

  newFlashcards: Array<Flashcard> = [];
  subjects: Array<Subject>;
  flashcards: Array<Flashcard>;
  set: FlashcardSet = new FlashcardSet;
  userId: number = JSON.parse(this.cookie.get('user')).userId;
  authorId: number;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router, private setTracker: SetTrackerService) { }

  ngOnInit() {
    this.client.get(`${environment.context}subjects`)
      .subscribe(
        (succ: any) => {
          this.subjects = succ;
        }
      );
    this.client.get(`${environment.context}flashcards/set/${this.setTracker.setId}`)
      .subscribe(
        (succ: any) => {
          this.flashcards = succ;
        }
      );
    this.client.get(`${environment.context}sets/id/${this.setTracker.setId}`)
      .subscribe(
        (succ: any) => {
          this.set = succ;
          this.authorId = this.set.author.userId;
        }
      );
  }

  addNewFlashcard() {
    this.newFlashcards.push(new Flashcard(0, 0, new FlashcardSet, '', '', JSON.parse(this.cookie.get('user'))));
  }

  removeNewFlashcard() {
    this.newFlashcards.pop();
  }

  updateSet() {
    this.set.status.statusId = 1;
    this.client.post(`${environment.context}/sets`, this.set)
      .subscribe(
        (succ: any) => {
          this.set = succ;
          this.newFlashcards.forEach(element => {
            element.fcSet = this.set;
            element.author = this.set.author;
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
        },
        (err) => {
          alert('Failed to add flashcard');
        }
      );
  }

  checkSubmit() {
    let bool = false;
    if (this.set.title === '' || this.set.subject.id === 0) {
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

  deleteFc(fcId: number) {
    // this.setTracker.setId = this.set.fcSetId;
    if (this.userId !== this.authorId) {
      return;
    } else {
      this.client.delete(`${environment.context}flashcards/id/${fcId}`)
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
      this.client.delete(`${environment.context}sets/id/${this.setTracker.setId}`)
        .subscribe(
          (succ: any) => {
          },
          (err: any) => {
            alert('failed to delete');
          }
        );
      this.flashcards.forEach(fc => {
        this.client.delete(`${environment.context}flashcards/id/${fc.flashcardId}`)
          .subscribe(
            (succ: any) => {
            },
            (err: any) => {
              alert('failed to delete fcs');
            }
          );
      });
    }
    this.router.navigateByUrl('flashcards/view');
  }

}
