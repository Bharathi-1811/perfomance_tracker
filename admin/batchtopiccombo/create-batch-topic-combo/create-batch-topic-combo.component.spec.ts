import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateBatchTopicComboComponent } from './create-batch-topic-combo.component';

describe('CreateBatchTopicComboComponent', () => {
  let component: CreateBatchTopicComboComponent;
  let fixture: ComponentFixture<CreateBatchTopicComboComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateBatchTopicComboComponent]
    });
    fixture = TestBed.createComponent(CreateBatchTopicComboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
