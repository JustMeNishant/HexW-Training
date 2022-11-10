import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user.model';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-student-register',
  templateUrl: './student-register.component.html',
  styleUrls: ['./student-register.component.css']
})
export class StudentRegisterComponent implements OnInit {

  user: User;
  constructor(private studentService: StudentService, private router: Router) { }

  ngOnInit(): void {
  }

  onFormSubmit(userForm: NgForm){
    this.user ={
      name: userForm.value.name,
      contact: userForm.value.contact,
      email: userForm.value.email
    };

    console.log(this.user);
    this.studentService.userSubject.next(this.user);
    this.router.navigateByUrl('/enroll-success');
  }
}
