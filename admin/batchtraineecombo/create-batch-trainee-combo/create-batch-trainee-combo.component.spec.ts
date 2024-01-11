import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBatchTraineeComboComponent } from './create-batch-trainee-combo.component';

describe('CreateBatchTraineeComboComponent', () => {
  let component: CreateBatchTraineeComboComponent;
  let fixture: ComponentFixture<CreateBatchTraineeComboComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateBatchTraineeComboComponent]
    });
    fixture = TestBed.createComponent(CreateBatchTraineeComboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
