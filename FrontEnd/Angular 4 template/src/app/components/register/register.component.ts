import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { User } from '../../beans/user';
import { environment } from '../../../environments/environment.prod';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private client: HttpClient, private cookie: CookieService) { }

  newUser = {
    username: '',
    password: '',
    email: '',
    firstname: '',
    lastname: ''
  };

  ngOnInit() {
  }

  addUser(user: User) {
    this.client.post(`${environment.context}users`, this.newUser)
      .subscribe(
        (succ: any) => {
          alert('You have successfully added a user.');
        },
        (err) => {
          alert('Failed to add user.');
        }
      );
  }
}
