package com.lizon.addressmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lizon.addressmanagement.entities.Address;
import com.lizon.addressmanagement.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@GetMapping("addresses")
	private List<Address> list() {
		return addressService.listAll();
	}
	
	@GetMapping("{addressId}")
	private Address findIPAddress(
			@PathVariable String addressId
			) {
		return addressService.findIPAddress(addressId);
	}
	
	@GetMapping("status/{addressId}")
	private String ipAddressStatus(
			@PathVariable String addressId
			) {
		return addressService.ipAddressStatus(addressId);
	}
	
	@PutMapping("update/{addressId}")
	private Address updateIpAddressStatus(
			@PathVariable String addressId
			) {
		return addressService.updateIpAddressStatus(addressId);
	}
	
	@PostMapping("add/{cidrStart}/{cidrEnd}")
	private List<Address> addIpAddresses(
			@PathVariable String cidrStart,
			@PathVariable String cidrEnd			
			) {
		return addressService.addAddresses(cidrStart, cidrEnd);
	}
}
