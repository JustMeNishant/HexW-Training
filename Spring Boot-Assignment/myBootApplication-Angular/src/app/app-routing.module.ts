import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookFlightComponent } from './component/book-flight/book-flight.component';
import { BookingConfirmationComponent } from './component/booking-confirmation/booking-confirmation.component';
import { HomeComponent } from './component/home/home.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { PostFlightComponent } from './component/post-flight/post-flight.component';
import { PostSuccessfulComponent } from './component/post-successful/post-successful.component';

const routes: Routes = [
  {path : '', component: HomeComponent},
  {path: 'post-flight', component: PostFlightComponent},
  {path: 'book-flight', component: BookFlightComponent},
  {path: 'booking-confirmation', component: BookingConfirmationComponent},
  {path: 'post-successful',component: PostSuccessfulComponent},
  {path: '**', component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
