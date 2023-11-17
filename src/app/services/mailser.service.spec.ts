import { TestBed } from '@angular/core/testing';

import { MailserService } from './mailser.service';

describe('MailserService', () => {
  let service: MailserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MailserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
