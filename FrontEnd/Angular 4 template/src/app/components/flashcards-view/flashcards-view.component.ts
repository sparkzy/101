import { Component, OnInit } from '@angular/core';
import { SetTrackerService } from '../../services/set-tracker.service';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Flashcard } from '../../beans/flashcard';
import { DynamicSortService } from '../../services/dynamic-sort.service';
import { FlashcardSet } from '../../beans/flashcardSet';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flashcards-view',
  templateUrl: './flashcards-view.component.html',
  styleUrls: ['./flashcards-view.component.css']
})
export class FlashcardsViewComponent implements OnInit {

  set: FlashcardSet;
  flashcards: Array<Flashcard>;
  idx = 0;
  flipped = false;
  userId: number = JSON.parse(this.cookie.get('user')).userId;
  authorId: number;

  constructor(private setTracker: SetTrackerService, private client: HttpClient, private sorter: DynamicSortService,
    private cookie: CookieService, private router: Router) { }

  ngOnInit() {
    this.setTracker.setId = parseInt(this.router.url.substring(this.router.url.lastIndexOf('/') + 1), 10);
    this.client.get(`${environment.context}sets/id/${this.setTracker.setId}`)
      .subscribe(
        (succ: any) => {
          this.set = succ;
          this.authorId = this.set.author.userId;
        },
        (err: any) => {
          this.router.navigateByUrl('flashcards/view');
        }
      );
    this.client.get(`${environment.context}flashcards/set/${this.setTracker.setId}`)
      .subscribe(
        (succ: any) => {
          this.flashcards = succ;
          this.sorter.arraySort(this.flashcards, 'flashcardId');
        },
        (err: any) => {
          // alert('failed to get flashcards');
        }
      );
  }

  OnDestroy() {
    this.setTracker.setId = undefined;
  }

  next() {
    this.idx++;
    if (this.idx === this.flashcards.length) {
      this.idx = 0;
    }
    this.flipped = false;
  }

  prev() {
    this.idx--;
    if (this.idx === -1) {
      this.idx = this.flashcards.length - 1;
    }
    this.flipped = false;
  }

  flip() {
    this.flipped = !this.flipped;
  }

  like() {
    this.set.likes++;
    this.client.put(`${environment.context}sets`, this.set)
      .subscribe(
        (succ: any) => { },
        (err: any) => {
          alert('fialed to like set 3');
        }
      );
  }

  report() {
    if (this.userId === this.authorId) {
      return;
    } else {
      // this.client.delete(`${environment.context}sets/id/${this.setTracker.setId}`)
      //   .subscribe(
      //     (err: any) => {
      //       alert('failed to delete');
      //     }
      //   );
      this.router.navigateByUrl('flashcards/view');
    }
  }

  delete() {
    if (this.userId !== this.authorId) {
      return;
    } else {
      this.client.delete(`${environment.context}sets/id/${this.setTracker.setId}`)
        .subscribe(
          (err: any) => {
            alert('failed to delete');
          }
        );
      this.flashcards.forEach(fc => {
        this.client.delete(`${environment.context}flashcards/id/${fc.flashcardId}`)
          .subscribe(
            (err: any) => {
              alert('failed to delete fcs');
            }
          );
      });
      this.router.navigateByUrl('flashcards/view');
    }
  }

  share() {

  }

  edit() {
    this.router.navigateByUrl('flashcards/edit');
  }

}
