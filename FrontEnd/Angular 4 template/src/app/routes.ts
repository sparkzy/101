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
    path: '**',
    pathMatch: 'full',
    redirectTo: 'login'
  }
];
