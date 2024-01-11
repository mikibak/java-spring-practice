import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SlopeListComponent } from './slope-list.component';

describe('SlopeListComponent', () => {
  let component: SlopeListComponent;
  let fixture: ComponentFixture<SlopeListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SlopeListComponent]
    });
    fixture = TestBed.createComponent(SlopeListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
