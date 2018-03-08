import { Routes } from '@angular/router';
import { Component } from '@angular/core';
import { CookieService } from 'angular2-cookie/services/cookies.service';
import { FlashcardSetComponent } from './components/flashcard-set/flashcard-set.component';

export const appRoutes: Routes = [
    {
        path: 'set',
        component: FlashcardSetComponent,
        children: [
            {
                path: 'create',
                component: FlashcardSetComponent,
            }
        ]
    }
];
