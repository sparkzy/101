import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import {AppComponent} from './app.component';
import {NavComponent} from './nav/nav.component';

import { appRoutes } from './routes';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { DatePipe } from '@angular/common';
import { CreateFlashcardSetComponent } from './componenets/create-flashcard-set/create-flashcard-set.component';
import { FlashcardSetComponent } from './components/flashcard-set/flashcard-set.component';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    HttpClientModule,
    NgbModule.forRoot(),
    RouterModule.forRoot(appRoutes, { useHash: true }),
    FormsModule
  ],
  declarations: [
    AppComponent,
    NavComponent,
    CreateFlashcardSetComponent,
    FlashcardSetComponent,
   ],
  providers: [
    CookieService,
    DatePipe
   ],
  bootstrap: [AppComponent]
})
export class AppModule { }
