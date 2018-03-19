import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { LoggedInGuard } from './guards/logged-in.guard';
import { HasSetGuard } from './guards/has-set.guard';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { SearchUserComponent } from './components/search-user/search-user.component';
import { FlashcardSet } from './beans/flashcardSet';
import { FlashcardSetComponent } from './components/flashcard-set/flashcard-set.component';
import { FlashcardSetCreateComponent } from './components/flashcard-set-create/flashcard-set-create.component';
import { FlashcardSetViewComponent } from './components/flashcard-set-view/flashcard-set-view.component';
import { PostComponent } from './compoment/post/post.component';
import { SubjectsComponent } from './components/subjects/subjects.component';
import { SearchpostComponent } from './components/searchpost/searchpost.component';
import { FlashcardsViewComponent } from './components/flashcards-view/flashcards-view.component';
import { FlashcardSetEditComponent } from './components/flashcard-set-edit/flashcard-set-edit.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizCreateComponent } from './components/quiz-create/quiz-create.component';
import { QuizUpdateComponent } from './components/quiz-update/quiz-update.component';
import { QuizViewComponent } from './components/quiz-view/quiz-view.component';
import { PostsComponent } from './components/posts/posts.component';
import { QuizTakeComponent } from './components/quiz-take/quiz-take.component';
import { HasQuizGuard } from './guards/has-quiz.guard';

export const appRoutes: Routes = [
  {
    path: 'subject',
    component: SubjectsComponent
  },
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
        path: 'set',
        component: FlashcardsViewComponent,
        canActivate: [
          LoggedInGuard,
          HasSetGuard
        ]
      },
      {
        path: 'set/:id',
        component: FlashcardsViewComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
      {
        path: 'edit',
        component: FlashcardSetEditComponent,
        canActivate: [
          LoggedInGuard,
          HasSetGuard
        ]
      }
    ],
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
          LoggedInGuard,
          HasQuizGuard
        ]
      },
      {
        path: 'view',
        component: QuizViewComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
      {
        path: 'take/:id',
        component: QuizTakeComponent,
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
    path: 'post',
    component: PostsComponent,
    children: [
      {
        path: 'create',
        component: PostComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
      {
        path: 'update',
        component: SearchpostComponent,
        canActivate: [
          LoggedInGuard
        ]
      },
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
