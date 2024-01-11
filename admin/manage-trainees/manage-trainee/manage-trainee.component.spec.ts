import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageTraineeComponent } from './manage-trainee.component';

describe('ManageTraineeComponent', () => {
  let component: ManageTraineeComponent;
  let fixture: ComponentFixture<ManageTraineeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageTraineeComponent]
    });
    fixture = TestBed.createComponent(ManageTraineeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
