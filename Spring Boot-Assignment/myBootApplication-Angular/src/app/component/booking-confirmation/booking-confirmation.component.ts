import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Flight } from 'src/app/model/flight.model';
import { FlightServiceService } from 'src/app/service/flight-service.service';

@Component({
  selector: 'app-booking-confirmation',
  templateUrl: './booking-confirmation.component.html',
  styleUrls: ['./booking-confirmation.component.css']
})
export class BookingConfirmationComponent implements OnInit {
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
    this.sum = (fareForm.value.no_of_adult*this.flight.adultFare) + 
                (fareForm.value.no_of_children*this.flight.childFare);
  }

}
