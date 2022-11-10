import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LmsPortalService } from 'src/app/service/lms-portal.service';
import { Employee } from '../model/employee.model';

@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {


  constructor(private lmsPortalService:LmsPortalService,private router:Router) { }

  ngOnInit(): void {
  }

  onLeaveSubmit(leaveForm:NgForm){

    // To calculate the no. of days between two dates
    var date1:any = new Date(leaveForm.value.startDate);
    var date2:any = new Date(leaveForm.value.endDate);
    var diffDays:any = Math.floor((date2 - date1) / (1000 * 60 * 60 * 24));

    console.log(diffDays);

    let employee : Employee ={
    name : leaveForm.value.name,
    startDate : leaveForm.value.startDate,
    endDate : leaveForm.value.endDate,
    leaveDays : diffDays,
    leaveType : leaveForm.value.leaveType,
    leaveReason : leaveForm.value.leaveReason,
    leaveStatus : "Pending",
    leaveBalance : 30 - diffDays
    }
    this.lmsPortalService.applyLeave(employee).subscribe();
    this.router.navigateByUrl('/leave-status');
  }

  onCancel(){
    console.log("cancel");
  }
}
