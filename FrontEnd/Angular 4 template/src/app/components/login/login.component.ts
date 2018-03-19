import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credential = {
    username: '',
    password: ''
  };

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.client.post(`${environment.context}users/login`, this.credential)
      .subscribe(
        (succ: Object) => {
          this.cookie.set('user', JSON.stringify(succ));
          console.log(JSON.stringify(succ));
        },
        (err) => {
          alert('Failed to log in.');
        }
      );
      this.router.navigateByUrl('home');
  }

}
