import { Pipe, PipeTransform } from '@angular/core';
import { Quiz } from '../beans/quiz';

@Pipe({
  name: 'quizSubject'
})
export class QuizSubjectPipe implements PipeTransform {

  transform(quizzes: Array<Quiz>, subject: String): Array<Quiz> {
    if (!subject) {
      return quizzes;
    }
    if (!quizzes) {
      return [];
    }
    return quizzes.filter(set => set.subject.subjectName.toLowerCase().includes(subject.toLowerCase()));
  }

}
