import { Component, OnInit,OnDestroy } from '@angular/core';
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
  empArr: Employee[] = [];
  studentArr : Student[] =[];
  employee: Employee;

  constructor(private employeeService: EmployeeService,
      private studentService: StudentService){ } //injecting ES

  ngOnInit(): void {
     this.employeeService.getAllEmployees().subscribe(data=>{
      this.empArr = data;
     });

     this.studentService.getAllStudents().subscribe(data=>{
        this.studentArr = data;
     });

  }

  deleteEmployee(eid: number){
      this.employeeService.deleteEmployee(eid).subscribe(
        data=>{
          this.empArr = this.empArr.filter(e=>e.id != eid);
        }
      );
  }

  onEmployeeSubmit(employeeForm:NgForm){
      // console.log(employeeForm.value.name);
      // console.log(employeeForm.value.city);
      // console.log(employeeForm.value.salary);
      // console.log(employeeForm.value.startDate);
      // console.log(employeeForm.value.startTime);
       this.employee ={
        name: employeeForm.value.name,
        city: employeeForm.value.city,
        salary: employeeForm.value.salary
      }

      this.employeeService.postEmployee(this.employee)
      .subscribe(data=>{
          this.empArr.push(data);
      });

      employeeForm.reset();
  }
  ngOnDestroy(): void {

  }

}
