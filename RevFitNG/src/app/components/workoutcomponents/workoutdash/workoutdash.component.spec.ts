import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkoutdashComponent } from './workoutdash.component';

describe('WorkoutdashComponent', () => {
  let component: WorkoutdashComponent;
  let fixture: ComponentFixture<WorkoutdashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkoutdashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkoutdashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
