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
	
//	public boolean ipAddressAvailable(String addy) {
//		return repo.findByIpAddress(addy).getAvailable();
//	}
	public String ipAddressStatus(String addy) {
		String status = "";
		Address targetAddress = repo.findByIpAddress(addy);
		if(targetAddress.getAvailable() == true){
			status = targetAddress.getIpAddress() + ": available"; 
		} else {
			status = targetAddress.getIpAddress() + ": acquired";
		}

		return status;
	}
	
	public Address updateIpAddressStatus(String address) {
		Address ipAddress = repo.findByIpAddress(address);
		if(ipAddress.getAvailable() == true) {
			ipAddress.setAvailable(false);
			repo.save(ipAddress);
		} else {
			ipAddress.setAvailable(true);
			repo.save(ipAddress);
		}
		
		return ipAddress;
	}

	
}
