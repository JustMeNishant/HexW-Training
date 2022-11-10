package com.spring.main.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.main.model.Employee;
import com.spring.main.service.EmployeeService;

@Controller 
public class MainController {
	 
	@RequestMapping("/")
	public String showIndex(Model model) { //Dependency Injection
		//send the value of user to jsp 
		model.addAttribute("username", "harry");
		model.addAttribute("age", 20);
		return "home";
	}
	
	@RequestMapping("/employee-details")
	public String showLogin(Employee employee, 
			HttpServletRequest request) {
		employee.setId(1);
		employee.setName("harry potter");
		employee.setSalary(85000);
		employee.setCity("london");
		request.setAttribute("employee", employee);
		return "employee";
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView showDashboard(ModelAndView mav) {
		List<Integer> list =Arrays.asList(1,2,3,4,5,6);
		mav.addObject("list", list);
		mav.setViewName("dashboard");
		return mav;
	}
	
}










