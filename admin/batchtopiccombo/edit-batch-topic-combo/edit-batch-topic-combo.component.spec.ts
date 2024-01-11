import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditBatchTopicComboComponent } from './edit-batch-topic-combo.component';

describe('EditBatchTopicComboComponent', () => {
  let component: EditBatchTopicComboComponent;
  let fixture: ComponentFixture<EditBatchTopicComboComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EditBatchTopicComboComponent]
    });
    fixture = TestBed.createComponent(EditBatchTopicComboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
