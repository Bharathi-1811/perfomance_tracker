import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditBatchTraineeComboComponent } from './edit-batch-trainee-combo.component';

describe('EditBatchTraineeComboComponent', () => {
  let component: EditBatchTraineeComboComponent;
  let fixture: ComponentFixture<EditBatchTraineeComboComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditBatchTraineeComboComponent]
    });
    fixture = TestBed.createComponent(EditBatchTraineeComboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
