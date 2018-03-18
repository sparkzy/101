import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Post } from '../../beans/post';
import { environment } from '../../../environments/environment';


@Component({
  selector: 'app-searchpost',
  templateUrl: './searchpost.component.html',
  styleUrls: ['./searchpost.component.css']
})
export class SearchpostComponent implements OnInit {

  constructor(private client: HttpClient) { }

  post: any;
  newPost = {
    title: '',
    author: '',
    body: '',
    subject: ''

  };

  ngOnInit() {
  }
  searchPost(post: Post): void {
    this.client.get(`${environment.context}post/author/${this.newPost.author}`)
      .subscribe(
        (succ: any) => {
          this.post = succ;
          alert('You have successfully searched for a user.');
        },
        (err) => {
          alert('Failed to find user.');
        }
      );
  }

}
