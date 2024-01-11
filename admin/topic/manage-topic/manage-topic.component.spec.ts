import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageTopicComponent } from './manage-topic.component';

describe('ManageTopicComponent', () => {
  let component: ManageTopicComponent;
  let fixture: ComponentFixture<ManageTopicComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageTopicComponent]
    });
    fixture = TestBed.createComponent(ManageTopicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
