import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeftcardComponent } from './leftcard.component';

describe('LeftcardComponent', () => {
  let component: LeftcardComponent;
  let fixture: ComponentFixture<LeftcardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeftcardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeftcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
