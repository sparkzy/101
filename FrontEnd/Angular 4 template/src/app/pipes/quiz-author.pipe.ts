import { Pipe, PipeTransform } from '@angular/core';
import { Quiz } from '../beans/quiz';

@Pipe({
  name: 'quizAuthor'
})
export class QuizAuthorPipe implements PipeTransform {

  transform(quizzes: Array<Quiz>, author: String): Array<Quiz> {
    if (!author) {
      return quizzes;
    }
    if (!quizzes) {
      return [];
    }
    return quizzes.filter(set => set.author.username.toLowerCase().includes(author.toLowerCase()));
  }

}
