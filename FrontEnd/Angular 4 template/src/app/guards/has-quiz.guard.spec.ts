import { TestBed, async, inject } from '@angular/core/testing';

import { HasQuizGuard } from './has-quiz.guard';

describe('HasQuizGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HasQuizGuard]
    });
  });

  it('should ...', inject([HasQuizGuard], (guard: HasQuizGuard) => {
    expect(guard).toBeTruthy();
  }));
});
