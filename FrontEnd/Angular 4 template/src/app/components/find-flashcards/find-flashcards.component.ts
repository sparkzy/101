import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { Flashcard } from '../../beans/flashcard';
import { environment } from '../../../environments/environment';

@Component({
  selector: 'app-find-flashcards',
  templateUrl: './find-flashcards.component.html',
  styleUrls: ['./find-flashcards.component.css']
})
export class FindFlashcardsComponent implements OnInit {

  flashcards: Array<Flashcard> = [];

  cookieObject;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
    this.cookieObject = this.cookie.get('user');
    this.client.get(`${environment.context}flashcards`,
      { withCredentials: true })
      .subscribe(
        (succ: Array<Flashcard>) => {
          this.flashcards = succ;
        },
        (err) => {
          console.log('Failed to load flashcards.');
        }
      );
  }

}
