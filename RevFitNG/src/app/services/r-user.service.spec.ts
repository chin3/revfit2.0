import { TestBed } from '@angular/core/testing';

import { RUserService } from './r-user.service';

describe('RUserService', () => {
  let service: RUserService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RUserService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
