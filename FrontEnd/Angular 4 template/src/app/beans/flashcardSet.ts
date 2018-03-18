import { Subject } from './subject';
import { User } from './user';
import { Flashcard } from './flashcard';
import { Status } from './status';

export class FlashcardSet {
    fcSetId: number;
    subject: Subject;
    title: string;
    likes: number;
    author: User;
    status: Status;

    constructor(id: number = 0, subject: Subject = new Subject, title: string = '',
        likes: number = 0, authorId: number = 0, author: User = new User, status: Status = new Status) {
        this.fcSetId = id;
        this.subject = subject;
        this.title = title;
        this.likes = likes;
        this.author = author;
        this.status = status;
    }
}
