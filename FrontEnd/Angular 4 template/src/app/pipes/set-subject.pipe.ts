import { Pipe, PipeTransform } from '@angular/core';
import { FlashcardSet } from '../beans/flashcardSet';

@Pipe({
  name: 'setSubject'
})
export class SetSubjectPipe implements PipeTransform {

  transform(sets: Array<FlashcardSet>, subject: String): Array<FlashcardSet> {
    if (!subject) {
      return sets;
    }
    if (!sets) {
      return [];
    }
    return sets.filter(set => set.subject.subjectName.toLowerCase().includes(subject.toLowerCase()));
  }

}
