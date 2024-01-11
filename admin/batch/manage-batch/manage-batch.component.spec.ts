import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageBatchComponent } from './manage-batch.component';

describe('ManageBatchComponent', () => {
  let component: ManageBatchComponent;
  let fixture: ComponentFixture<ManageBatchComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageBatchComponent]
    });
    fixture = TestBed.createComponent(ManageBatchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
