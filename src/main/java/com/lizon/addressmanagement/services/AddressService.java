package com.lizon.addressmanagement.services;

import java.util.ArrayList;
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
		Address targetAddress = repo.findByIpAddress(address);
		if(targetAddress.getAvailable() == true) {
			targetAddress.setAvailable(false);
			repo.save(targetAddress);
		} else {
			targetAddress.setAvailable(true);
			repo.save(targetAddress);
		}
		
		return targetAddress;
	}
	
//	"10.0.0.10/20"
	public List<Address> addAddresses(String addressStart, String addressEnd) {
		List<Address> listNewAddresses = new ArrayList<>();

		String[] ipNotation = addressStart.split("\\.");
		int startRange = Integer.parseInt(ipNotation[3]);
		int endRange = Integer.parseInt(addressEnd);
		
		
		for(int i = startRange; i <= endRange; i++) {
			String addIpAddress = ipNotation[0] + "." + ipNotation[1] + "." + ipNotation[2] + "." + i;
			
			if(repo.findByIpAddress(addIpAddress) == null) {
				Address newAddress = new Address();
				newAddress.setIpAddress(addIpAddress);
				newAddress.setAvailable(true);
				repo.save(newAddress);
				
				listNewAddresses.add(newAddress);
			}
		}
		
		return listNewAddresses;
	}
	
}
