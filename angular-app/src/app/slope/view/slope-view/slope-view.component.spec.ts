import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlopeViewComponent } from './slope-view.component';

describe('SlopeViewComponent', () => {
  let component: SlopeViewComponent;
  let fixture: ComponentFixture<SlopeViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SlopeViewComponent]
    });
    fixture = TestBed.createComponent(SlopeViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
