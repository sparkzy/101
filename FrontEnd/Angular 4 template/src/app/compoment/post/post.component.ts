import { Component, OnInit } from '@angular/core';
import { Subject } from '../../beans/subject';
import { HttpClient } from '@angular/common/http';
import { Post } from '../../beans/post';
import { environment } from '../../../environments/environment.prod';
import { User } from '../../beans/user';
import { Status } from '../../beans/status';
import { CookieService } from 'ngx-cookie-service';
import { SetTrackerService } from '../../services/set-tracker.service';
import { Router } from '@angular/router';



@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  newPost: Post = new Post;
  post: any = [];
  subject: Array<Subject> = [];
  newStatus: Status = new Status;
  postId: number;
  userId: number = JSON.parse(this.cookie.get('user')).userId;
  authorId: number;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router ) { }

  ngOnInit() {
    this.client.get(`${environment.context}/posts`)
    .subscribe(
      (succ: any) => {
        this.post = succ;
      },
      (err) => {
        console.log(this.newStatus);
      }
    );
    this.client.get(`${environment.context}/status`)
    .subscribe(
      (succ: any) => {
        this.newStatus = succ;
      },
      (err) => {
        console.log(this.newStatus);
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

  addPost() {
   this.newPost.author = JSON.parse(this.cookie.get('user'));
   this.newPost.status.statusId = 1;
    this.client.post(`${environment.context}posts`, this.newPost)
    .subscribe(
      (succ: Array<Subject>) => {

         this.ngOnInit();
      },
      (err) => {


      }
    );
  }
  delete(postid: number) {

   this.client.delete(`${environment.context}/posts/id/${postid}`)
    .subscribe(
      (succ: any) => {

        this.ngOnInit();

      },
      (err) => {
        this.ngOnInit();

      }
    );

  }
  like(posts: Post) {
    posts.likes++;
    this.client.put(`${environment.context}posts`, posts)
      .subscribe(
        (succ: any) => { },
        (err: any) => {
        }
      );
  }
}

