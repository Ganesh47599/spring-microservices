package com.microservice.employeeapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.employeeapp.entity.Employee;
import com.microservice.employeeapp.repository.EmployeeRepository;
import com.microservice.employeeapp.response.EmployeeResponse;
import com.microservice.employeeapp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
		@GetMapping("/employees/{id}")
	ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id){
EmployeeResponse employee=employeeService.getEmployeeById(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(employee);
	}
}
