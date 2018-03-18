import { FlashcardSet } from './flashcardSet';
import { User } from './user';

export class Flashcard {
    flashcardId: number;
    fcSet: FlashcardSet;
    question: string;
    answer: string;
    author: User;

    constructor(id: number = 0, setId: number = 0, set: FlashcardSet = new FlashcardSet, question: string = '',
        answer: string = '', author: User = new User) {
        this.flashcardId = id;
        this.fcSet = set;
        this.question = question;
        this.answer = answer;
        this.author = author;
    }
}
