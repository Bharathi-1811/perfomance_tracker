import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateUpcomingComponent } from './create-upcoming.component';

describe('CreateUpcomingComponent', () => {
  let component: CreateUpcomingComponent;
  let fixture: ComponentFixture<CreateUpcomingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreateUpcomingComponent]
    });
    fixture = TestBed.createComponent(CreateUpcomingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
