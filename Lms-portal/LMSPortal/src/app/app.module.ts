import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './component/nav-bar/nav-bar.component';
import { HomeComponent } from './component/home/home.component';
import { ApplyLeaveComponent } from './component/apply-leave/apply-leave.component';
import { LeaveStatusComponent } from './component/leave-status/leave-status.component';
import { LeaveRequestComponent } from './component/leave-request/leave-request.component';
import { ViewRequestComponent } from './component/view-request/view-request.component';
import { FormsModule } from '@angular/forms';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    ApplyLeaveComponent,
    LeaveStatusComponent,
    LeaveRequestComponent,
    ViewRequestComponent,
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
