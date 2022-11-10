import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Flight } from 'src/app/model/flight.model';
import { FlightServiceService } from 'src/app/service/flight-service.service';

@Component({
  selector: 'app-book-flight',
  templateUrl: './book-flight.component.html',
  styleUrls: ['./book-flight.component.css']
})
export class BookFlightComponent implements OnInit {
  source:string;
  destination:string;
  departureDate:string;
  flightArr:Flight[];

  constructor(private flighService: FlightServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  searchSubmit(searchFlight: NgForm){
    this.source = searchFlight.value.source;
    this.destination = searchFlight.value.destination;
    this.departureDate = searchFlight.value.departureDate;
    console.log(searchFlight.value.source+" "+searchFlight.value.destination+" "+searchFlight.value.departureDate); 
    this.flighService.filteredFlight(this.source,this.destination,this.departureDate).subscribe(data=>{
      this.flightArr = data;
    });
  }
  selectFlight(id: number){
    console.log(id);
    localStorage.setItem('id',String(id));
    this.router.navigateByUrl('/booking-confirmation');
  }
}
