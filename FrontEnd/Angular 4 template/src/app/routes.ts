import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoggedInGuard } from './guards/logged-in.guard';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { SearchUserComponent } from './components/search-user/search-user.component';
import { FlashcardSet } from './beans/flashcardSet';
import { FlashcardSetComponent } from './components/flashcard-set/flashcard-set.component';
import { FlashcardSetCreateComponent } from './components/flashcard-set-create/flashcard-set-create.component';
import { FlashcardSetSearchComponent } from './components/flashcard-set-search/flashcard-set-search.component';
import { FlashcardSetViewComponent } from './components/flashcard-set-view/flashcard-set-view.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizCreateComponent } from './components/quiz-create/quiz-create.component';
import { QuizUpdateComponent } from './components/quiz-update/quiz-update.component';
import { QuizDeleteComponent } from './components/quiz-delete/quiz-delete.component';

export const appRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'searchusers',
    component: SearchUserComponent,
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'flashcards',
    component: FlashcardSetComponent,
    children: [
      {
        path: 'create',
        component: FlashcardSetCreateComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
      {
        path: 'view',
        component: FlashcardSetViewComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
      {
        path: 'search',
        component: FlashcardSetSearchComponent,
        canActivate: [
          LoggedInGuard
        ]
      }],
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: 'quiz',
    component: QuizComponent,
    children: [
      {
        path: 'create',
        component: QuizCreateComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
      {
        path: 'update',
        component: QuizUpdateComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
      {
        path: 'delete',
        component: QuizDeleteComponent,
        canActivate: [
          LoggedInGuard
        ]
      }
    ],
    canActivate: [
      LoggedInGuard
    ]
  },
  {
    path: '**',
    pathMatch: 'full',
    redirectTo: 'login'
  }
];
