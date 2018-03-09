import { Component } from '@angular/core';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {
  constructor(private cookie: CookieService, private router: Router) { }

  logout(): void {
    this.cookie.delete('user');
    this.router.navigateByUrl('/login');
  }
}
