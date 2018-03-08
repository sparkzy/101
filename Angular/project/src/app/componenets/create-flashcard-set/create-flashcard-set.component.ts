import { Component, OnInit } from '@angular/core';
import { Flashcard } from '../../entities/flashcard';
import { Subject } from '../../entities/subject';
import { HttpClient } from 'selenium-webdriver/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-flashcard-set',
  templateUrl: './create-flashcard-set.component.html',
  styleUrls: ['./create-flashcard-set.component.css']
})
export class CreateFlashcardSetComponent implements OnInit {

  flashcard: Array<Flashcard>;
  authorId: number;
  title: string;
  subjects: Array<Subject>;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

}
