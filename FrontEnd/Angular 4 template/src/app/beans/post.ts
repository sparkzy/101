import { User } from './user';
import { Subject } from './subject';
import { Status } from './status';




export class Post {
    postId: number;
    title: string;
    author: User;
    body: string;
    status: Status;
    subject: Subject;

//  constructor(id: number = 0, title: string = '', author: User = new User, body: string = '',
//         status: Status = new Status, subject: Subject = new Subject) {
//         this.postId = id;
//         this.title = title;
//         this.author = author;
//         this.status = status;
//         this.subject = subject;
//     }
}
