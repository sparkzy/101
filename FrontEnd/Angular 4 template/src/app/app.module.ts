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
import { FlashcardSetViewComponent } from './components/flashcard-set-view/flashcard-set-view.component';
import { DynamicSortService } from './services/dynamic-sort.service';
import { SetTitlePipe } from './pipes/set-title.pipe';
import { SetAuthorPipe } from './pipes/set-author.pipe';
import { SetSubjectPipe } from './pipes/set-subject.pipe';
import { FilterPipe } from './pipes/filter.pipe';

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
    FlashcardSetViewComponent,
    SetTitlePipe,
    SetAuthorPipe,
    SetSubjectPipe,
    FilterPipe
  ],
  providers: [
    LoggedInGuard,
    CookieService,
    NgbDropdown,
    DynamicSortService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
