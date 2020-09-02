import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftgendashComponent } from './leftgendash.component';

describe('LeftgendashComponent', () => {
  let component: LeftgendashComponent;
  let fixture: ComponentFixture<LeftgendashComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftgendashComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftgendashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
