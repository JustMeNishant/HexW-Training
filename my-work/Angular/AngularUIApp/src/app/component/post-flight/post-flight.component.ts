import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Flight } from 'src/app/model/flight.model';
import { FlightServiceService } from 'src/app/service/flight-service.service';

@Component({
  selector: 'app-post-flight',
  templateUrl: './post-flight.component.html',
  styleUrls: ['./post-flight.component.css']
})
export class PostFlightComponent implements OnInit {

  constructor(private flightService: FlightServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  onFlighttSubmit(flightForm: NgForm){
    let flight : Flight={
      name:flightForm.value.name,
      source:flightForm.value.source,
      destination:flightForm.value.destination,
      depatureDate:flightForm.value.depatureDate,
      depatureTime:flightForm.value.depatureTime,
      arrivalDate:flightForm.value.arrivalDate,
      arrivalTime:flightForm.value.arrivalTime,
      duration:flightForm.value.duration,
      adultFare:flightForm.value.adultFare,
      childFare:flightForm.value.childFare,
      seats:flightForm.value.seats,
    };

    this.flightService.postFlight(flight).subscribe();
    this.router.navigateByUrl('/post-successful');
  }

}
