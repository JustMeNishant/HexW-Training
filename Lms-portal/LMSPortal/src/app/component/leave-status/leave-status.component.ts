import { Component, OnInit } from '@angular/core';
import { LmsPortalService } from 'src/app/service/lms-portal.service';
import { Employee } from '../model/employee.model';
import { LeaveRequest } from '../model/leaveRequest.model';

@Component({
  selector: 'app-leave-status',
  templateUrl: './leave-status.component.html',
  styleUrls: ['./leave-status.component.css']
})
export class LeaveStatusComponent implements OnInit {
  leaveRequestArr:LeaveRequest[];
  constructor(private lmsPortalService:LmsPortalService) { }

  ngOnInit(): void {
    this.lmsPortalService.getAllRequests().subscribe(data=>{
      this.leaveRequestArr = data;
    });
  }

}
