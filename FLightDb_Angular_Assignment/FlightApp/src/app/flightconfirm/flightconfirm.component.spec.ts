import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightconfirmComponent } from './flightconfirm.component';

describe('FlightconfirmComponent', () => {
  let component: FlightconfirmComponent;
  let fixture: ComponentFixture<FlightconfirmComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightconfirmComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightconfirmComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
