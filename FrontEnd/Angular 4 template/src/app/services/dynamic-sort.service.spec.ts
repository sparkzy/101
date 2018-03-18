import { TestBed, inject } from '@angular/core/testing';

import { DynamicSortService } from './dynamic-sort.service';

describe('DynamicSortService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DynamicSortService]
    });
  });

  it('should be created', inject([DynamicSortService], (service: DynamicSortService) => {
    expect(service).toBeTruthy();
  }));
});
