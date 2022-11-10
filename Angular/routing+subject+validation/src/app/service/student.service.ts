import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { User } from '../model/user.model';

@Injectable({
  providedIn: 'root'
})
export class StudentService {

  userSubject = new BehaviorSubject<User>({});
  constructor() { }
}
