import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CoursesComponent } from './components/courses/courses.component';
import { EnrollSuccessComponent } from './components/enroll-success/enroll-success.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { StudentRegisterComponent } from './components/student-register/student-register.component';

const routes: Routes = [
  {'path': '', component: HomeComponent},
  {'path': 'courses', component: CoursesComponent},
  {'path': 'login', component: LoginComponent},
  {'path': 'student-register', component: StudentRegisterComponent},
  {'path': 'enroll-success', component: EnrollSuccessComponent},
  {'path': '**', component: PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
