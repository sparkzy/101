import { Component, OnInit } from '@angular/core';
import { Subject } from '../../beans/subject';
import { HttpClient } from '@angular/common/http';
import { Post } from '../../beans/post';
import { environment } from '../../../environments/environment.prod';
import { User } from '../../beans/user';
import { Status } from '../../beans/status';
import { CookieService } from 'ngx-cookie-service';
// import { CookieService } from 'angular2-cookie/services/cookies.service';


@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
   // newPost: Post = new Post;
   newPost = {
    postId: 0,
    title: '',
    author: '',
    body: '',
    subject: ''

   };
   post: any = [];
  subject: Array<Subject> = [];
  newStatus: Status = new Status;
  postId: number;



  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
    this.client.get(`${environment.context}/posts`)
    .subscribe(
      (succ: any) => {
        this.post = succ;
        console.log('hey');
        console.log(this.newPost);
        console.log(this.newStatus);
      },
      (err) => {
        console.log(this.newStatus);
        alert('failed to get any subjects');
      }
    );
    this.client.get(`${environment.context}/status`)
    .subscribe(
      (succ: any) => {
        this.newStatus = succ;
        console.log(this.newStatus);
      },
      (err) => {
        console.log(this.newStatus);
        alert('failed to get any subjects');
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
    this.client.post(`${environment.context}posts`, this.newPost)
    .subscribe(
      (succ: Array<Subject>) => {
         this.subject = succ;
         console.log(this.newStatus);
         console.log(this.newPost);
        alert('new post added');
      },
      (err) => {
        console.log(this.newStatus);
        console.log(this.newPost );
        alert('failed');
      }
    );
  }
  delete(post: Post): void {
    // this.newPost = newPost;
    // console.log(newPost);
    // console.log(this.newPost.postId);
    // console.log(this.post.postId);
    this.client.delete(`${environment.context}/posts/id/${this.newPost.postId}`)
    .subscribe(
      (succ: any) => {
        this.post = succ;
        alert('deleted');

      },
      (err) => {
        alert('deleted not');
        console.log(this.post.postId);
        console.log(this.newPost.postId);

      }
    );
  }
}

