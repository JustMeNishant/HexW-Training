import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightbookComponent } from './flightbook.component';

describe('FlightbookComponent', () => {
  let component: FlightbookComponent;
  let fixture: ComponentFixture<FlightbookComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightbookComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightbookComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
