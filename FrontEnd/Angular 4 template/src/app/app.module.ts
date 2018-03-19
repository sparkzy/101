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
import { FlashcardSetViewComponent } from './components/flashcard-set-view/flashcard-set-view.component';
import { PostComponent } from './compoment/post/post.component';
import { SubjectsComponent } from './components/subjects/subjects.component';
import { SearchpostComponent } from './components/searchpost/searchpost.component';
import { DynamicSortService } from './services/dynamic-sort.service';
import { SetAuthorPipe } from './pipes/set-author.pipe';
import { SetSubjectPipe } from './pipes/set-subject.pipe';
import { FilterPipe } from './pipes/filter.pipe';
import { FlashcardsViewComponent } from './components/flashcards-view/flashcards-view.component';
import { SetTrackerService } from './services/set-tracker.service';
import { HasSetGuard } from './guards/has-set.guard';
import { FlashcardSetEditComponent } from './components/flashcard-set-edit/flashcard-set-edit.component';
import { ClickStopPropagationDirective } from './directives/click-stop-propagation.directive';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizCreateComponent } from './components/quiz-create/quiz-create.component';
import { QuizUpdateComponent } from './components/quiz-update/quiz-update.component';
import { QuizViewComponent } from './components/quiz-view/quiz-view.component';
import { QuizAuthorPipe } from './pipes/quiz-author.pipe';
import { QuizSubjectPipe } from './pipes/quiz-subject.pipe';
import { QuizTakeComponent } from './components/quiz-take/quiz-take.component';
import { QuizTrackerService } from './services/quiz-tracker.service';
import { HasQuizGuard } from './guards/has-quiz.guard';

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
    FlashcardSetViewComponent,
    PostComponent,
    SubjectsComponent,
    SearchpostComponent,
    FlashcardSetViewComponent,
    SetAuthorPipe,
    SetSubjectPipe,
    FilterPipe,
    FlashcardsViewComponent,
    FlashcardSetEditComponent,
    ClickStopPropagationDirective,
    QuizComponent,
    QuizCreateComponent,
    QuizUpdateComponent,
    QuizViewComponent,
    QuizAuthorPipe,
    QuizSubjectPipe,
    QuizTakeComponent
  ],
  providers: [
    LoggedInGuard,
    CookieService,
    NgbDropdown,
    DynamicSortService,
    SetTrackerService,
    HasSetGuard,
    QuizTrackerService,
    HasQuizGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
