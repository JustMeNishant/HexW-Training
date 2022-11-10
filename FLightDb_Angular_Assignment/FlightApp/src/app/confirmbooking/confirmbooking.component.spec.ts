import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Flight } from 'src/app/model/Flight';
import { FlightServiceService } from '../services/flightservice';
import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Confirmbook } from './confirmbooking.component';

describe('ConfirmbookingComponent', () => {
  let component: Confirmbook;
  let fixture: ComponentFixture<Confirmbook>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Confirmbook ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Confirmbook);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
