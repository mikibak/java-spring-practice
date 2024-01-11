import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkiResortEditComponent } from './ski-resort-edit.component';

describe('SkiResortEditComponent', () => {
  let component: SkiResortEditComponent;
  let fixture: ComponentFixture<SkiResortEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SkiResortEditComponent]
    });
    fixture = TestBed.createComponent(SkiResortEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
