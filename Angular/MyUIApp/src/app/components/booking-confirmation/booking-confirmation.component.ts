import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/model/doctor.model';
import { Slot } from 'src/app/model/slot.model';
import { PatientService } from 'src/app/service/patient.service';

@Component({
  selector: 'app-booking-confirmation',
  templateUrl: './booking-confirmation.component.html',
  styleUrls: ['./booking-confirmation.component.css']
})
export class BookingConfirmationComponent implements OnInit {
  name: string;
  contact: string;
  doctorId: string;
  slotId: string;
  apptDate: string;
  doctor: Doctor;
  slot: Slot;
  constructor(private patientService: PatientService) { }

  ngOnInit(): void {

    this.name = localStorage.getItem('name');
    this.contact = localStorage.getItem('contact');
    this.doctorId = localStorage.getItem('doctorId');
    this.slotId = localStorage.getItem('slotId');
    this.apptDate = localStorage.getItem('apptDate');

    this.patientService.getDoctorInfo(this.doctorId).subscribe(data=>{
        this.doctor = data;
    });

    this.patientService.getSlotInfo(this.slotId).subscribe(data=>{
      this.slot = data;
  });

  }

}
