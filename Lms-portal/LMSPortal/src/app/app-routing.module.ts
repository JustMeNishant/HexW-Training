import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ApplyLeaveComponent } from './component/apply-leave/apply-leave.component';
import { HomeComponent } from './component/home/home.component';
import { LeaveRequestComponent } from './component/leave-request/leave-request.component';
import { LeaveStatusComponent } from './component/leave-status/leave-status.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { ViewRequestComponent } from './component/view-request/view-request.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'apply-leave',component:ApplyLeaveComponent},
  {path:'leave-status',component:LeaveStatusComponent},
  {path:'leave-request',component:LeaveRequestComponent},
  {path:'view-request',component:ViewRequestComponent},
  {path:'**',component:PageNotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
