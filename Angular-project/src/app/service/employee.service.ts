import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {


  constructor(private http:HttpClient) { } //injecting a service

  getAllEmployees() : Observable<Employee[]>{
    return this.http.get<Employee[]>('http://localhost:8181/employee/all');
  }

  deleteEmployee(eid: number):Observable<any> {
     return this.http.delete('http://localhost:8181/employee/delete/' + eid);
  }

  postEmployee(employee: Employee) : Observable<Employee>{
    return this.http.post<Employee>('http://localhost:8181/employee/insert',
            employee);
  }

}
