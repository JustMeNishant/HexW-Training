import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Flight } from 'src/app/model/Flight';
import { FlightServiceService } from 'src/app/services/flightservice';
@Component({
  selector: 'app-insertflight',
  templateUrl: './insertflight.component.html',
  styleUrls: ['./insertflight.component.css']
})
export class InsertflightComponent implements OnInit {

  constructor(private flightService: FlightServiceService,private router:Router) { }

  ngOnInit(): void {
  }
  onFlightSubmit(flightForm: NgForm){
    let flight : Flight={
      name:flightForm.value.name,
      source:flightForm.value.source,
      destination:flightForm.value.destination,
      depdate:flightForm.value.depdate,
      deptime:flightForm.value.deptime,
      arrdate:flightForm.value.arrdate,
      arrtime:flightForm.value.arrtime,
      duration:flightForm.value.duration,
      adultfare:flightForm.value.adultfare,
      childfare:flightForm.value.childfare,
      seats:flightForm.value.seats,
    };

    this.flightService.postFlight(flight).subscribe();
    this.router.navigateByUrl('/flightconfirm');
  }

}
