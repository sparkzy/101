import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';
import { SetTrackerService } from '../services/set-tracker.service';

@Injectable()
export class HasSetGuard implements CanActivate {

  constructor(private setTracker: SetTrackerService, private router: Router) { }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this.setTracker.setId) {
      return true;
    } else {
      this.router.navigateByUrl('flashcards/view');
    }
  }
}
