import { User } from './user';
import { Subject } from './subject';
import { Quiz } from './quiz';

export class Question {
    questionId: number;
    quiz: Quiz;
    question: string;
    correctAnswer: string;
    wrongAnswer1: string;
    wrongAnswer2: string;
    wrongAnswer3: string;

    constructor(questionId: number = 0, quiz: Quiz = new Quiz, question: string = '', correctAnswer: string = '',
        wrongAnswer1: string = '', wrongAnswer2: string = '', wrongAnswer3: string = '') {
        this.questionId = questionId;
        this.quiz = quiz;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer1 = wrongAnswer1;
        this.wrongAnswer2 = wrongAnswer2;
        this.wrongAnswer3 = wrongAnswer3;
    }
}
