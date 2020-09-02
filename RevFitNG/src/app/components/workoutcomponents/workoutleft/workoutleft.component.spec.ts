import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkoutleftComponent } from './workoutleft.component';

describe('WorkoutleftComponent', () => {
  let component: WorkoutleftComponent;
  let fixture: ComponentFixture<WorkoutleftComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkoutleftComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkoutleftComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
