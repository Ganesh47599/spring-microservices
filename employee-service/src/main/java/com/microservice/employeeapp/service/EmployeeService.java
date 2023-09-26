package com.microservice.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.employeeapp.entity.Employee;
import com.microservice.employeeapp.repository.EmployeeRepository;
import com.microservice.employeeapp.response.AddressResponse;
import com.microservice.employeeapp.response.EmployeeResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RestTemplate restTemplate;
	
	

	public EmployeeService(@Value("${address.base.uri}") String addressBaseUri,RestTemplateBuilder  builder) {
		// TODO Auto-generated constructor stub
		System.out.println(addressBaseUri);
		this.restTemplate=builder.rootUri(addressBaseUri).
				build();
	}

	public EmployeeResponse getEmployeeById(int id) {
		
		AddressResponse  addressResponse=new AddressResponse();
		Employee employee = employeeRepository.findById(id).get();
		EmployeeResponse employeeResponse =

				mapper.map(employee, EmployeeResponse.class);
//	addressResponse=	restTemplate.getForObject("http://localhost:8081/address/{id}",AddressResponse.class,id);
//		employeeResponse.setAddressResponse(addressResponse);

		
		addressResponse=	restTemplate.getForObject("http://localhost:8081/address/{id}",AddressResponse.class,id);
		employeeResponse.setAddressResponse(addressResponse);
//		employeeResponse.setId(employee.getId());
//		employeeResponse.setName(employee.getName());
//		employeeResponse.setEmail(employee.getEmail());
//		employeeResponse.setBloodGroup(employee.getBloodGroup());

		return employeeResponse;
	}

}
