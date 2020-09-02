import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkouttimerComponent } from './workouttimer.component';

describe('WorkouttimerComponent', () => {
  let component: WorkouttimerComponent;
  let fixture: ComponentFixture<WorkouttimerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ WorkouttimerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(WorkouttimerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
