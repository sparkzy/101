export class Subject {
<<<<<<< HEAD
    subjectName: string;
    subjectId: number;

    constructor(subjectName: string = '', subjectId: number = 0) {
        this.subjectName = subjectName;
        this.subjectId = subjectId;
=======
    id: number;
    subjectName: string;

    constructor(id: number = 0, name: string = '') {
        this.id = id;
        this.subjectName = name;
>>>>>>> d44c9711713cf5ae8fc2c25491c9c06fa943bf08
    }
}
