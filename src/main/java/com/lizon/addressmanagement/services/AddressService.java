package com.lizon.addressmanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lizon.addressmanagement.entities.Address;
import com.lizon.addressmanagement.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repo;
	
	public List<Address> listAll() {
		return repo.findAll(); 
	}
	
	public Address findIPAddress(String addy) {
		return repo.findByIpAddress(addy);
	}
	
	public boolean ipAddressAvailable(String addy) {
		return repo.findByIpAddress(addy).getAvailable();
	}
	

	
}
