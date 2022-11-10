package com.spring.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.main.model.Employee;
import com.spring.main.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService; 
	
	@Autowired
	private Employee employee;
	
	@RequestMapping("/all-employees")
	public String showAllEmployees(Model model) {
		//reach out to service class and fetch list having all employee objects
		return "redirect:redirect-employee";

	}
	
	 
	@RequestMapping("/delete-employee")
	public String deleteEmployeeById(@RequestParam("id") Integer id,Model model) {
		employeeService.deleteEmployeeById(id);
		return "redirect:redirect-employee";
	}
	
	@RequestMapping("/insert-employee")
	public String insertEmployee(@RequestParam("ename") String name, 
							   @RequestParam("ecity") String city, 
							   @RequestParam("esalary") double salary ,
							   Model model) {
		employee.setName(name);
		employee.setSalary(salary);
		employee.setCity(city);
		
		employeeService.insertEmployee(employee);
		return "redirect:redirect-employee";
	}
	
	@RequestMapping("/redirect-employee")
	public String redirect(Model model) {
		employee.setName("");
		employee.setCity("");
		model.addAttribute("employee", employee);
		
		List<Employee> list = 
				employeeService.fetchAllEmployees(); 
		model.addAttribute("list", list);
		return "all-employee";
	}
	
	@RequestMapping("/edit-employee")
	public String updateEmployee(@RequestParam("id") Integer id,Model model) {
		
		List<Employee> list = 
				employeeService.fetchAllEmployees(); 
		
		for(Employee e : list) {
			if(e.getId() == id) {
				employee = e;
				break; 
			}
		}
		model.addAttribute("flag", "edit");
		model.addAttribute("employee",employee);
		model.addAttribute("list", list);
		return "all-employee";
	}
	
	@RequestMapping("/edit-employee-op")
	public String processEdit(@RequestParam("id") Integer id,
							@RequestParam("ename") String name, 
							@RequestParam("ecity") String city, 
							@RequestParam("esalary") double salary ,
							Model model) {
		
		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);
		employee.setCity(city);
		
		//go to service and execute edit op.. 
		employeeService.processEdit(employee);
		return "redirect:redirect-employee";
		
	}
}
