import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageBatchTopicComboComponent } from './manage-batch-topic-combo.component';

describe('ManageBatchTopicComboComponent', () => {
  let component: ManageBatchTopicComboComponent;
  let fixture: ComponentFixture<ManageBatchTopicComboComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageBatchTopicComboComponent]
    });
    fixture = TestBed.createComponent(ManageBatchTopicComboComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
