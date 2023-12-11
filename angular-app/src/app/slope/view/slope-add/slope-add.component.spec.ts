import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlopeAddComponent } from './slope-add.component';

describe('SlopeAddComponent', () => {
  let component: SlopeAddComponent;
  let fixture: ComponentFixture<SlopeAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SlopeAddComponent]
    });
    fixture = TestBed.createComponent(SlopeAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
