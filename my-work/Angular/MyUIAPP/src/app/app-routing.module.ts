import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllAppointmentComponent } from './component/all-appointment/all-appointment.component';
import { BookingConfirmationComponent } from './component/booking-confirmation/booking-confirmation.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { PatientAppointmentComponent } from './component/patient-appointment/patient-appointment.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'patient-appointment',component:PatientAppointmentComponent},
  {path:'all-appointments',component:AllAppointmentComponent},
  {path:'booking-confirmation',component:BookingConfirmationComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
