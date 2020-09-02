import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkoutgendashComponent } from './workoutgendash.component';

describe('WorkoutgendashComponent', () => {
  let component: WorkoutgendashComponent;
  let fixture: ComponentFixture<WorkoutgendashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkoutgendashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkoutgendashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
