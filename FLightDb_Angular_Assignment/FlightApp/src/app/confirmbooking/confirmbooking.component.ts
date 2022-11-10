import { Component, OnInit } from '@angular/core';
import { FlightServiceService } from '../services/flightservice';

import { NgForm } from '@angular/forms';
import { Flight } from 'src/app/model/Flight';

@Component({
  selector: 'app-confirmbooking',
  templateUrl: './confirmbooking.component.html',
  styleUrls: ['./confirmbooking.component.css']
})
export class Confirmbook implements OnInit {
  id:string;
  flightArr:Flight[];
  flight:Flight;
  name:string;
  sum:number = 0;
  constructor(private flightService:FlightServiceService) { }

  ngOnInit(): void {
    this.id = localStorage.getItem('id');

    this.flightService.getFlightDetailsById(this.id).subscribe(data=>{
    this.flight = data;
    });
  }

  change(fareForm: NgForm){
    this.sum = (fareForm.value.no_of_adult*this.flight.adultfare) + 
                (fareForm.value.no_of_children*this.flight.childfare);
  }

}
