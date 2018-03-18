import { TestBed, async, inject } from '@angular/core/testing';

import { HasSetGuard } from './has-set.guard';

describe('HasSetGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HasSetGuard]
    });
  });

  it('should ...', inject([HasSetGuard], (guard: HasSetGuard) => {
    expect(guard).toBeTruthy();
  }));
});
