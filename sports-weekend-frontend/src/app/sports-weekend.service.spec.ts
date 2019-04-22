import { TestBed } from '@angular/core/testing';

import { SportsWeekendService } from './sports-weekend.service';

describe('SportsWeekendService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SportsWeekendService = TestBed.get(SportsWeekendService);
    expect(service).toBeTruthy();
  });
});
