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
    likes: number;
    constructor(postId: number = 0, title: string= '', author: User = new User, body: string = '',
    status: Status = new Status, subject: Subject = new Subject, likes = 0) {
        this.postId = postId;
        this.title = title;
        this.author = author;
        this.body = body;
        this.status = status;
        this.subject = subject;
        this.likes = likes;
    }


}
