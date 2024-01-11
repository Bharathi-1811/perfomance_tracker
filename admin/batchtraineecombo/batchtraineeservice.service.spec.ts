import { TestBed } from '@angular/core/testing';

import { BatchtraineeserviceService } from './batchtraineeservice.service';

describe('BatchtraineeserviceService', () => {
  let service: BatchtraineeserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BatchtraineeserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
