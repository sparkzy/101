import { Pipe, PipeTransform } from '@angular/core';
import { Post } from '../beans/post';

@Pipe({
  name: 'subjectPost'
})
export class SubjectPostPipe implements PipeTransform {

  transform(sets: Array<Post>, subject: String): Array<Post> {
    if (!subject) {
      return sets;
    }
    if (!sets) {
      return [];
    }
    return sets.filter(set => set.subject.subjectName.toLowerCase().includes(subject.toLowerCase()));
  }


}
