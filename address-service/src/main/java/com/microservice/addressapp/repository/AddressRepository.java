package com.microservice.addressapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.microservice.addressapp.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
//address based on employee id
	
	@Query(nativeQuery = true, value = "SELECT ea.id,ea.line1,ea.line2,ea.state,ea.zip FROM microservice.address ea join microservice.employee e on e.id=ea.employee_id where ea.employee_id=:employeeId")
Address	findAddressByEmployeeId(@Param("employeeId") int employeeId);
}
