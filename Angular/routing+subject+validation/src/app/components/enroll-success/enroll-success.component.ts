import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user.model';
import { StudentService } from 'src/app/service/student.service';

@Component({
  selector: 'app-enroll-success',
  templateUrl: './enroll-success.component.html',
  styleUrls: ['./enroll-success.component.css']
})
export class EnrollSuccessComponent implements OnInit {

  user:User;
  constructor(private studentService: StudentService) { }

  ngOnInit(): void {
    this.studentService.userSubject.subscribe(data=>{
        this.user = data;
    });
  }

}
