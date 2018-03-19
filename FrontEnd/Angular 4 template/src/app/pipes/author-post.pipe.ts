import { Pipe, PipeTransform } from '@angular/core';
import { Post } from '../beans/post';

@Pipe({
  name: 'authorPost'
})
export class AuthorPostPipe implements PipeTransform {

  transform(posts: Array<Post>, author: string): Array<Post> {
    if (!author) {
      return posts;
    }
    if (!posts) {
      return [];
    }
    return posts.filter(post => post.author.username.toLowerCase().includes(author.toLowerCase()));
  }

}
