import { Pipe, PipeTransform } from '@angular/core';
import { FlashcardSet } from '../beans/flashcardSet';

@Pipe({
  name: 'setTitle'
})
export class SetTitlePipe implements PipeTransform {

  transform(sets: Array<FlashcardSet>, title: String): Array<FlashcardSet> {
    if (title === undefined) {
      return sets;
    }
    if (!sets) {
      return sets;
    }
    return sets.filter(set => set.title.toLowerCase() === title.toLowerCase());
  }

}
