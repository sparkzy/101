import { Subject } from './subject';
import { User } from './user';
import { Flashcard } from './flashcard';

export class FlashcardSet {
    fcSetId: number;
    subject: Subject;
    title: string;
    likes: number;
    author: User;

    constructor(id: number = 0, subjectId: number = 0, subject: Subject = new Subject, title: string = '',
        likes: number = 0, authorId: number = 0, author: User = new User) {
        this.fcSetId = id;
        this.subject = subject;
        this.title = title;
        this.likes = likes;
        this.author = author;
    }
}
