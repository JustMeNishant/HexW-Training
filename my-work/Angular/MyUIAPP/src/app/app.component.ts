import { Component, OnDestroy, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Employee } from './model/employee.model';
import { Student } from './model/student.model';
import { EmployeeService } from './service/employee.service';
import { StudentService } from './service/student.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy{

  employeeArr:Employee[] = [];
  studentArr:Student[] = [];
  employee: Employee;

  constructor (private employeeService:EmployeeService,
                private studentService:StudentService) { }
  
  ngOnInit(): void {
    this.employeeService.getAllEmployees().subscribe(data=>{
      this.employeeArr = data;
    });

    this.studentService.getAllStudents().subscribe(data=>{
      this.studentArr=data;
    });

  }

  onEmployeeSubmit(employeeForm:NgForm){
    //console.log(employeeForm.value.name);
    //console.log(employeeForm.value.city);
    //console.log(employeeForm.value.salary);
    this.employee = {
      name:employeeForm.value.name,
      city:employeeForm.value.city,
      salary:employeeForm.value.salary
    }
    this.employeeService.postEmployee(this.employee).subscribe(data=>{
      this.employeeArr.push(data);
    });

    employeeForm.reset();
  }


  deleteEmployee(eid: number){
    console.log(eid);
    this.employeeService.deleteEmployee(eid).subscribe(data=>{
      this.employeeArr=this.employeeArr.filter(e=> e.id != eid);
    });
  }

  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
}
