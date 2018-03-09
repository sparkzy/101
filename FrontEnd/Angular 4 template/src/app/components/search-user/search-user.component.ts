import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../../beans/user';
import { environment } from '../../../environments/environment.prod';

@Component({
  selector: 'app-search-user',
  templateUrl: './search-user.component.html',
  styleUrls: ['./search-user.component.css']
})
export class SearchUserComponent implements OnInit {

  constructor(private client: HttpClient) { }

  user: any;

  newUser = {
    username: '',
    password: '',
    email: '',
    firstname: '',
    lastname: ''
  };

  ngOnInit() {
  }

  searchUser(user: User): void {
    this.client.get(`${environment.context}users/username/${this.newUser.username}`)
      .subscribe(
        (succ: any) => {
          this.user = succ;
          alert('You have successfully searched for a user.');
        },
        (err) => {
          alert('Failed to find user.');
        }
      );
  }
}
