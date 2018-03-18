import { TestBed, inject } from '@angular/core/testing';

import { QuizTrackerService } from './quiz-tracker.service';

describe('QuizTrackerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [QuizTrackerService]
    });
  });

  it('should be created', inject([QuizTrackerService], (service: QuizTrackerService) => {
    expect(service).toBeTruthy();
  }));
});
