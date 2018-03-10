export class FlashcardSet {
    id: number;
    subjectId: number;
    title: string;
    likes: number;
    authorId: number;

    constructor(id: number = 0, subjectId: number = 0, title: string = '', likes: number = 0, authorId: number = 0) {
        this.id = id;
        this.subjectId = subjectId;
        this.title = title;
        this.likes = likes;
        this.authorId = authorId;
    }
}
