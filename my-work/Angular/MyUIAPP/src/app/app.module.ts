import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { PatientComponent } from './patient/patient.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { HomeComponent } from './component/home/home.component';
import { PatientAppointmentComponent } from './component/patient-appointment/patient-appointment.component';
import { AllAppointmentComponent } from './component/all-appointment/all-appointment.component';
import { BookingConfirmationComponent } from './component/booking-confirmation/booking-confirmation.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';



@NgModule({
  declarations: [
    AppComponent,
    PatientComponent,
    NavBarComponent,
    HomeComponent,
    PatientAppointmentComponent,
    AllAppointmentComponent,
    BookingConfirmationComponent,
    PageNotFoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
