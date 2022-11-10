import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightbookComponent } from './flightbook/flightbook.component';
import { Confirmbook } from './confirmbooking/confirmbooking.component';
import { HomeComponent } from './home/home.component';
import { IndexComponent } from './index/index.component';
import { InsertflightComponent } from './insertflight/insertflight.component';
import { FlightconfirmComponent } from './flightconfirm/flightconfirm.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';


@NgModule({
  declarations: [
    AppComponent,
    FlightbookComponent,
    Confirmbook,
    HomeComponent,
    IndexComponent,
    InsertflightComponent,
    FlightconfirmComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
