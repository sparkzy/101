import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'ngx-cookie-service';
import { environment } from '../../../environments/environment.prod';
import { Subject } from '../../beans/subject';
import { RouterLink, Router } from '@angular/router';

@Component({
  selector: 'app-subjects',
  templateUrl: './subjects.component.html',
  styleUrls: ['./subjects.component.css']
})
export class SubjectsComponent implements OnInit {
  newSub: Subject = new Subject;


  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
  }

addSubject() {
    this.client.post(`${environment.context}subjects`, this.newSub)
    .subscribe(
      (succ) => {
        console.log(this.newSub);
       this.ngOnInit();
       this.router.navigateByUrl('post/create');
      },
      (err) => {

      }
    );
  }
}
