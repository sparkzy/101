export class Subject {
    id: number;
    subjectName: string;

    constructor(id: number = 0, name: string = '') {
        this.id = id;
        this.subjectName = name;
    }
}
