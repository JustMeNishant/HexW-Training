import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment.model';
import { Doctor } from '../model/doctor.model';
import { Slot } from '../model/slot.model';

@Injectable({
  providedIn: 'root'
})
export class PatientService {


  constructor(private http: HttpClient) { }

  getAllDoctors() : Observable<Doctor[]>{
    return this.http.get<Doctor[]>('http://localhost:8181/doctor/all');
  }

  getAllSlots() : Observable<Slot[]>{
    return this.http.get<Slot[]>('http://localhost:8181/slots/all');
  }

  bookAppointment(appointment: Appointment) :Observable<Appointment>{
    return this.http.post<Appointment>('http://localhost:8181/book/appointment',appointment);
  }

  getDoctorInfo(doctorId: string) :Observable<Doctor>{
     return this.http.get<Doctor>('http://localhost:8181/doctor/' + doctorId);
  }

  getSlotInfo(slotId: string) :Observable<Slot>{
    return this.http.get<Slot>('http://localhost:8181/slot/' + slotId);

  }
}
