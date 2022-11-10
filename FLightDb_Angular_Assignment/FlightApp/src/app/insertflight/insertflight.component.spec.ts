import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InsertflightComponent } from './insertflight.component';

describe('InsertflightComponent', () => {
  let component: InsertflightComponent;
  let fixture: ComponentFixture<InsertflightComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ InsertflightComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(InsertflightComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
