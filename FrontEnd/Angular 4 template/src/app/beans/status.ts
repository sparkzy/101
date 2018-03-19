export class Status {
    statusId: number;
    statusName: string;

    constructor(id: number = 0, statusName: string = '') {
        this.statusId = id;
        this.statusName = statusName;
    }
}
