import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageBatchTraineeComboComponent } from './manage-batch-trainee-combo.component';

describe('ManageBatchTraineeComboComponent', () => {
  let component: ManageBatchTraineeComboComponent;
  let fixture: ComponentFixture<ManageBatchTraineeComboComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageBatchTraineeComboComponent]
    });
    fixture = TestBed.createComponent(ManageBatchTraineeComboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
