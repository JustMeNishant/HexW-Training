import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllAppointmentsComponent } from './components/all-appointments/all-appointments.component';
import { BookingConfirmationComponent } from './components/booking-confirmation/booking-confirmation.component';
import { HomeComponent } from './components/home/home.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { PatientAppointmentComponent } from './components/patient-appointment/patient-appointment.component';


const routes: Routes = [
  {path : '', component: HomeComponent},
  {path: 'patient-appointment', component: PatientAppointmentComponent},
  {path: 'all-appointments', component: AllAppointmentsComponent},
  {path: 'booking-confirmation', component: BookingConfirmationComponent},
  {path: '**', component: PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
