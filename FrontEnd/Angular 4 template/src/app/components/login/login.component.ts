import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { CookieService } from 'ngx-cookie-service';

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

  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
  }

  login() {
    this.client.post(`${environment.context}users/login`, this.credential)
      .subscribe(
        (succ: any) => {
          alert(`${succ.username}, you have successfully logged in.`);
          this.cookie.set('user', succ);

        },
        (err) => {
          alert('Failed to log in.');
        }
      );
  }

}
