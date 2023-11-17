import { TestBed } from '@angular/core/testing';

import { StatserService } from './statser.service';

describe('StatserService', () => {
  let service: StatserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(StatserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
