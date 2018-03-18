import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { QuizTrackerService } from '../services/quiz-tracker.service';

@Injectable()
export class HasQuizGuard implements CanActivate {

  constructor(private quizTracker: QuizTrackerService, private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.quizTracker.quizId) {
      return true;
    } else {
      this.router.navigateByUrl('quiz/view');
    }
  }
}
