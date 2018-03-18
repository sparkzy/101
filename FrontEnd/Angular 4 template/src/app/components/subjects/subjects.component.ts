import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { environment } from '../../../environments/environment.prod';
import { Subject } from '../../beans/subject';

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit {
  newSub: Subject = new Subject;


  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
  }

addSubject() {
    this.client.post(`${environment.context}subjects`, this.newSub)
    .subscribe(
      (succ) => {
        console.log(this.newSub);
        alert('new post added');
      },
      (err) => {
        console.log(this.newSub);
        alert('failed');
      }
    );
  }
}
