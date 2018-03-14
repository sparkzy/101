import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule, NgbDropdown } from '@ng-bootstrap/ng-bootstrap';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';

import { appRoutes } from './routes';
import { LoginComponent } from './components/login/login.component';
import { LoggedInGuard } from './guards/logged-in.guard';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { SearchUserComponent } from './components/search-user/search-user.component';
import { FlashcardSetComponent } from './components/flashcard-set/flashcard-set.component';
import { CookieService } from 'ngx-cookie-service';
import { FlashcardSetCreateComponent } from './components/flashcard-set-create/flashcard-set-create.component';
import { FlashcardSetSearchComponent } from './components/flashcard-set-search/flashcard-set-search.component';
import { FlashcardSetViewAllComponent } from './components/flashcard-set-view-all/flashcard-set-view-all.component';
import { FlashcardSetViewComponent } from './components/flashcard-set-view/flashcard-set-view.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizCreateComponent } from './components/quiz-create/quiz-create.component';
import { QuizUpdateComponent } from './components/quiz-update/quiz-update.component';
import { QuizDeleteComponent } from './components/quiz-delete/quiz-delete.component';


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
    LoginComponent,
    HomeComponent,
    RegisterComponent,
    SearchUserComponent,
    FlashcardSetComponent,
    FlashcardSetCreateComponent,
    FlashcardSetSearchComponent,
    FlashcardSetViewAllComponent,
    FlashcardSetViewComponent,
    QuizComponent,
    QuizCreateComponent,
    QuizUpdateComponent,
    QuizDeleteComponent
  ],
  providers: [
    LoggedInGuard,
    CookieService,
    NgbDropdown
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
