export class Flashcard {
    id: number;
    setId: number;
    question: string;
    answer: string;
    authorId: number;

    constructor(id: number = 0, setId: number = 0, question: string = '', answer: string = '', authorId: number = 0) {
        this.id = id;
        this.setId = setId;
        this.question = question;
        this.answer = answer;
        this.authorId = authorId;
    }
}
