import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../component/model/employee.model';
import { LeaveRequest } from '../component/model/leaveRequest.model';

@Injectable({
  providedIn: 'root'
})
export class LmsPortalService {

  constructor(private http: HttpClient) { }

  applyLeave(employee: Employee):Observable<Employee> {
    return this.http.post<Employee>("http://localhost:6432/leave/apply",employee);
  }

  fetchLeaveRequest():Observable<Employee[]> {
    return this.http.get<Employee[]>("http://localhost:6432/leave/fetchAll");
  }

  fetchLeaveById(id:string):Observable<Employee>{
    return this.http.get<Employee>("http://localhost:6432/leave/one/"+id);
  }

  updateLeaveRequest(leaveRequest:LeaveRequest):Observable<LeaveRequest>{
    return this.http.post<LeaveRequest>("http://localhost:6432/leave/update",leaveRequest);
  }

  getAllRequests():Observable<LeaveRequest[]> {
    return this.http.get<LeaveRequest[]>("http://localhost:6432/leaveRequest/fetchAll");
  }
}
