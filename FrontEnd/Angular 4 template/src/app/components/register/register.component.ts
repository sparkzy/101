import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';


import { User } from '../../beans/user';
import { environment } from '../../../environments/environment.prod';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  // newUser = {
  //   userId: 0,
  //   username: '',
  //   password: '',
  //   email: '',
  //   firstname: '',
  //   lastname: ''
  // };

  newUser = new User;

  ngOnInit() {
  }

  addUser(user: User) {
    this.client.post(`${environment.context}users`, this.newUser)
      .subscribe(
        (succ: any) => {
        },
        (err) => {
          alert('Failed to add user.');
        }
      );
      this.login();
  }

  login() {
    this.router.navigateByUrl('login');
  }
}
