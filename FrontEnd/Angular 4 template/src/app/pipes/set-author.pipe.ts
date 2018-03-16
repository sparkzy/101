import { Pipe, PipeTransform } from '@angular/core';
import { FlashcardSet } from '../beans/flashcardSet';

@Pipe({
  name: 'setAuthor'
})
export class SetAuthorPipe implements PipeTransform {

  transform(sets: Array<FlashcardSet>, author: String): Array<FlashcardSet> {
    if (!author) {
      return sets;
    }
    if (!sets) {
      return [];
    }
    return sets.filter(set => set.author.username.toLowerCase().includes(author.toLowerCase()));
  }

}
