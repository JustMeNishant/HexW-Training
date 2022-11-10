import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LmsPortalService } from 'src/app/service/lms-portal.service';
import { Employee } from '../model/employee.model';
import { LeaveRequest } from '../model/leaveRequest.model';

@Component({
  selector: 'app-view-request',
  templateUrl: './view-request.component.html',
  styleUrls: ['./view-request.component.css']
})
export class ViewRequestComponent implements OnInit {
  id:string;
  employee:Employee;
  comments:string;
  constructor(private lmsPortalService:LmsPortalService,private router:Router) { }

  ngOnInit(): void {
    this.id = localStorage.getItem('id');
    this.lmsPortalService.fetchLeaveById(this.id).subscribe(data=>{
      this.employee=data;
    });
  }
  approveLeave(updateLeaveForm:NgForm){
    this.employee.leaveStatus = "Approved";
    let leaveRequest : LeaveRequest ={
      comments : updateLeaveForm.value.comments,
      employee : this.employee 
    }
    this.lmsPortalService.updateLeaveRequest(leaveRequest).subscribe();
    this.router.navigateByUrl('/leave-request');
  }
  declineLeave(updateLeaveForm:NgForm){
    this.employee.leaveStatus = "Declined";
    let leaveRequest : LeaveRequest ={
      comments : updateLeaveForm.value.comments,
      employee : this.employee 
    }
    this.lmsPortalService.updateLeaveRequest(leaveRequest).subscribe();
    this.router.navigateByUrl('/leave-request');
  }
  Cancel(){
    this.router.navigateByUrl('/leave-request');
  }
}
