export class Subject {
    subjectName: string;
    subjectId: number;

    constructor(subjectName: string = '', subjectId: number = 0) {
        this.subjectName = subjectName;
        this.subjectId = subjectId;
    }
}
