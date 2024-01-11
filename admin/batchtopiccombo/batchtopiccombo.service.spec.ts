import { TestBed } from '@angular/core/testing';

import { BatchtopiccomboService } from './batchtopiccombo.service';

describe('BatchtopiccomboService', () => {
  let service: BatchtopiccomboService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BatchtopiccomboService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
