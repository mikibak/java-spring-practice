import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlopeEditComponent } from './slope-edit.component';

describe('SlopeEditComponent', () => {
  let component: SlopeEditComponent;
  let fixture: ComponentFixture<SlopeEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SlopeEditComponent]
    });
    fixture = TestBed.createComponent(SlopeEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
