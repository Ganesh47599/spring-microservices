package com.microservice.addressapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.addressapp.entity.Address;
import com.microservice.addressapp.repository.AddressRepository;
import com.microservice.addressapp.response.AddressResponse;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	
	@Autowired
	private ModelMapper mapper;
	public AddressResponse findAddressByEmployeeId(int employeeId) {
		Address  address=addressRepository.findAddressByEmployeeId(employeeId);
		AddressResponse  addressResponse=mapper.map(address, AddressResponse.class);
		return addressResponse;
	}
}
