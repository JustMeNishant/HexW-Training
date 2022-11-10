import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../model/Flight';

@Injectable({
  providedIn: 'root'
})
export class FlightServiceService {

  constructor(private http: HttpClient) { }

  postFlight(flight: Flight):Observable<any> {
    return this.http.post<any>("http://localhost:7007/flight/post",flight);
  }

  filteredFlight(source: string, destination: string, depdate: string):Observable<Flight[]> {
    return this.http.get<Flight[]>("http://localhost:7007/flight/get/"+source+"/"+destination+"/"+depdate+"");
  }

  getFlightDetailsById(id: string):Observable<Flight> {
    return this.http.get<Flight>("http://localhost:7007/flight/one/"+id);
  }

}