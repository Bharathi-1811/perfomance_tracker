import { TestBed } from '@angular/core/testing';

import { ManagetraineeService } from './managetrainee.service';

describe('ManagetraineeService', () => {
  let service: ManagetraineeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ManagetraineeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
