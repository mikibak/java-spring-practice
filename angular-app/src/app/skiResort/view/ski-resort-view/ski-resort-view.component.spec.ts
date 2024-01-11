import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkiResortViewComponent } from './ski-resort-view.component';

describe('SkiResortViewComponent', () => {
  let component: SkiResortViewComponent;
  let fixture: ComponentFixture<SkiResortViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SkiResortViewComponent]
    });
    fixture = TestBed.createComponent(SkiResortViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
