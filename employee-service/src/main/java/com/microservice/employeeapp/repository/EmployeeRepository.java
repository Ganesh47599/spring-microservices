package com.microservice.employeeapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.employeeapp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
