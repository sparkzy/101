import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../../beans/post';
import { environment } from '../../../environments/environment';
import { Subject } from '../../beans/subject';
import { Status } from '../../beans/status';
import { CookieService } from 'ngx-cookie-service';
import { SetTrackerService } from '../../services/set-tracker.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-searchpost',
  templateUrl: './searchpost.component.html',
  styleUrls: ['./searchpost.component.css']
})
export class SearchpostComponent implements OnInit {
  constructor(private client: HttpClient, private cookie: CookieService, private setTracker: SetTrackerService,
    private router: Router) { }
  posts: Post = new Post;
  newPost: Array<Post> = [];
  post: any = [];
  subject: Array<Subject> = [];
  newStatus: Status = new Status;
  postId: number;
  userId: number = JSON.parse(this.cookie.get('user')).userId;
  authorId: number;
  subjectFilter: '';
  authorFilter: '';
  ngOnInit() {
    this.client.get(`${environment.context}/status`)
    .subscribe(
      (succ: any) => {
        this.newStatus = succ;
      },
      (err) => {
        console.log('failed to get any subjects');
      }
    );
    this.client.get(`${environment.context}/subjects`)
    .subscribe(
      (succ: any) => {
        this.subject = succ;
        console.log(this.subject);
      },
      (err) => {

      }
    );
   }
  view(set: Post) {
    this.setTracker.setId = set.postId;

    this.ngOnInit();
  }
  searchPost()  {
    this.client.get(`${environment.context}/posts`)
    .subscribe(
      (succ: any) => {
        this.post = succ;
      },
      (err) => {
        console.log(this.newStatus);
       
      }
    );

  }
}
