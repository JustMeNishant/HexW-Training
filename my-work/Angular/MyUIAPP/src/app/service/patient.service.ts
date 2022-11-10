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

  getAllDoctors(): Observable<Doctor[]> {
    return this.http.get<Doctor[]>("http://localhost:9155/doctor/all");
  }
  getAllSlots(): Observable<Slot[]> {
    return this.http.get<Slot[]>("http://localhost:9155/slot/all");
  }
  bookAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>("http://localhost:9155/book/appointment", appointment);
  }
  getDoctorById(doctorId: string) :Observable<Doctor>{
    return this.http.get<Doctor>("http://localhost:9155/doctor/one/" + doctorId);
  }
  getSlotById(slotId: string) :Observable<Slot>{
    return this.http.get<Slot>("http://localhost:9155/slot/one/" + slotId);
  }
  getAllDetails() : Observable<Appointment[]>{
    return this.http.get<Appointment[]>("http://localhost:9155/appointments/all");
  }

}
