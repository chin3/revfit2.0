import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RightcardComponent } from './rightcard.component';

describe('RightcardComponent', () => {
  let component: RightcardComponent;
  let fixture: ComponentFixture<RightcardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RightcardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RightcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
