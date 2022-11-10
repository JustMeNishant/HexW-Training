import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { HomeComponent } from './component/home/home.component';
import { PostFlightComponent } from './component/post-flight/post-flight.component';
import { BookFlightComponent } from './component/book-flight/book-flight.component';
import { BookingConfirmationComponent } from './component/booking-confirmation/booking-confirmation.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { FormsModule } from '@angular/forms';
import { PostSuccessfulComponent } from './component/post-successful/post-successful.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    PostFlightComponent,
    BookFlightComponent,
    BookingConfirmationComponent,
    PageNotFoundComponent,
    PostSuccessfulComponent
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
