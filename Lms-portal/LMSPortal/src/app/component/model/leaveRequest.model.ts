import { Employee } from "./employee.model";

export class LeaveRequest{
    id?:number;
    employee:Employee;
    comments:string;
}
