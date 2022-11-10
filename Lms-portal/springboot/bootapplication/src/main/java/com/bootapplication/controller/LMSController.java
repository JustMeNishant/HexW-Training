package com.bootapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootapplication.model.Employee;
import com.bootapplication.model.LeaveRequest;
import com.bootapplication.repository.EmployeeRepository;
import com.bootapplication.repository.LeaveRequestRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:9849"})
public class LMSController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private LeaveRequestRepository leaveRequestRepository;

	@PostMapping("/leave/apply")
	public Employee applyLeave(@RequestBody Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	@PostMapping("/leave/update")
	public LeaveRequest updateLeave(@RequestBody LeaveRequest leaveRequest) {
		System.out.println(leaveRequest.getEmployee().getLeaveStatus()+"==="+leaveRequest.getEmployee().getId());
		employeeRepository.save(leaveRequest.getEmployee());
		return leaveRequestRepository.save(leaveRequest);
	}
	
	@GetMapping("/leave/fetchAll")
	public List<Employee> fetchLeaveRequest() {
		
		return employeeRepository.findAll();
	}
	
	@GetMapping("/leave/one/{id}")
	public Employee fetchLeaveById(@PathVariable("id") Long id) {
		
		Optional<Employee> optional = employeeRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException("Invalid ID");
		Employee e = optional.get();
		return e;
	}	
	@GetMapping("/leaveRequest/fetchAll")
	public List<LeaveRequest> fetchAllLeaveRequests() {
		return leaveRequestRepository.findAll();
	}
}
