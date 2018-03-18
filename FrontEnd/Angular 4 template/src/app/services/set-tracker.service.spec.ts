import { TestBed, inject } from '@angular/core/testing';

import { SetTrackerService } from './set-tracker.service';

describe('SetTrackerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SetTrackerService]
    });
  });

  it('should be created', inject([SetTrackerService], (service: SetTrackerService) => {
    expect(service).toBeTruthy();
  }));
});
