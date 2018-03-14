import { User } from './user';
import { Subject } from './subject';

export class Quiz {
    quizId: number;
    subject: Subject;
    likes: number;
    title: string;
    author: User;

    constructor(quizId: number = 0, subject: Subject = new Subject, likes: number = 0, title: string = '',
        author: User = new User) {
        this.quizId = quizId;
        this.subject = subject;
        this.likes = likes;
        this.title = title;
        this.author = author;
    }
}
