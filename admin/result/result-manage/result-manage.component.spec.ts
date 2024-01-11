import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultManageComponent } from './result-manage.component';

describe('ResultManageComponent', () => {
  let component: ResultManageComponent;
  let fixture: ComponentFixture<ResultManageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResultManageComponent]
    });
    fixture = TestBed.createComponent(ResultManageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
