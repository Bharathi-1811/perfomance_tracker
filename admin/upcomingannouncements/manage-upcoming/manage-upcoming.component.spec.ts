import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageUpcomingComponent } from './manage-upcoming.component';

describe('ManageUpcomingComponent', () => {
  let component: ManageUpcomingComponent;
  let fixture: ComponentFixture<ManageUpcomingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ManageUpcomingComponent]
    });
    fixture = TestBed.createComponent(ManageUpcomingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
