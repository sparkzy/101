export class Status {
    statusId: number;
    statusName: string;

    constructor(id: number = 1, statusName: string = 'not-banned') {
        this.statusId = id;
        this.statusName = statusName;
    }
}
