import { AuthorPostPipe } from './author-post.pipe';

describe('AuthorPostPipe', () => {
  it('create an instance', () => {
    const pipe = new AuthorPostPipe();
    expect(pipe).toBeTruthy();
  });
});
