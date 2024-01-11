import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TraineeGraphPiechartComponent } from './trainee-graph-piechart.component';

describe('TraineeGraphPiechartComponent', () => {
  let component: TraineeGraphPiechartComponent;
  let fixture: ComponentFixture<TraineeGraphPiechartComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TraineeGraphPiechartComponent]
    });
    fixture = TestBed.createComponent(TraineeGraphPiechartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
