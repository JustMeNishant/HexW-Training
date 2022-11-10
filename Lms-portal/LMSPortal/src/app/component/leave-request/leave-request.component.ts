import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LmsPortalService } from 'src/app/service/lms-portal.service';
import { Employee } from '../model/employee.model';

@Component({
  selector: 'app-leave-request',
  templateUrl: './leave-request.component.html',
  styleUrls: ['./leave-request.component.css']
})
export class LeaveRequestComponent implements OnInit {
  employeeArr:Employee[];

  constructor(private lmsPortalService:LmsPortalService,private router:Router) { }

  ngOnInit(): void {
    this.lmsPortalService.fetchLeaveRequest().subscribe(data=>{
      this.employeeArr = data;
    });
    console.log(this.employeeArr);
  }
  viewRequest(id:number){
    console.log(id);
    localStorage.setItem('id', String(id));
    this.router.navigateByUrl('/view-request');
  }

}
