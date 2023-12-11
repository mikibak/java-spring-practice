import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkiResortAddComponent } from './ski-resort-add.component';

describe('SkiResortAddComponent', () => {
  let component: SkiResortAddComponent;
  let fixture: ComponentFixture<SkiResortAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SkiResortAddComponent]
    });
    fixture = TestBed.createComponent(SkiResortAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
