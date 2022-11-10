import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/model/appointment.model';
import { PatientService } from 'src/app/service/patient.service';

@Component({
  selector: 'app-all-appointment',
  templateUrl: './all-appointment.component.html',
  styleUrls: ['./all-appointment.component.css']
})
export class AllAppointmentComponent implements OnInit {
  appointmentArr:Appointment[];
  constructor(private patientService: PatientService) { }

  ngOnInit(): void {
    this.patientService.getAllDetails().subscribe(data=>{
      this.appointmentArr=data;
    });
  }

}
