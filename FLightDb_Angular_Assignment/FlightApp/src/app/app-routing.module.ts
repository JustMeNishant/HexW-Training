import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightbookComponent } from 'src/app/flightbook/flightbook.component';
import { Confirmbook } from 'src/app/confirmbooking/confirmbooking.component';
import { HomeComponent } from 'src/app/home/home.component';
import { InsertflightComponent } from 'src/app/insertflight/insertflight.component';
import { FlightconfirmComponent } from 'src/app/flightconfirm/flightconfirm.component';

const routes: Routes = [
  {path : '', component: HomeComponent},
  {path: 'insertflight', component: InsertflightComponent},
  {path: 'flightbook', component: FlightbookComponent},
  {path: 'confirmbooking', component: Confirmbook},
  {path: 'flightconfirm',component: FlightconfirmComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

