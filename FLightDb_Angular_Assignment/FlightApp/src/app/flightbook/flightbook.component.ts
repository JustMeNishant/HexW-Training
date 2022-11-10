import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Flight } from 'src/app/model/Flight';
import { FlightServiceService } from 'src/app/services/flightservice';

@Component({
  selector: 'app-flightbook',
  templateUrl: './flightbook.component.html',
  styleUrls: ['./flightbook.component.css']
})
export class FlightbookComponent implements OnInit {
  source:string;
  destination:string;
  depdate:string;
  flightArr:Flight[];

  constructor(private flighService: FlightServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  searchSubmit(searchFlight: NgForm){
    this.source = searchFlight.value.source;
    this.destination = searchFlight.value.destination;
    this.depdate = searchFlight.value.depdate;
    console.log(searchFlight.value.source+" "+searchFlight.value.destination+" "+searchFlight.value.depdate); 
    this.flighService.filteredFlight(this.source,this.destination,this.depdate).subscribe(data=>{
      this.flightArr = data;
    });
  }
  selectFlight(id: number){
    console.log(id);
    localStorage.setItem('id',String(id));
    this.router.navigateByUrl('/confirmbooking');
  }
}