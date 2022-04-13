package com.lizon.addressmanagement.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lizon.addressmanagement.entities.Address;
import com.lizon.addressmanagement.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService addyService;
	
	@GetMapping("addresses")
	private List<Address> list() {
		return addyService.listAll();
	}
	
	@GetMapping("{addressId}")
	private Address findIPAddress(
			@PathVariable String addressId
			) {
		return addyService.findIPAddress(addressId);
	}
	
	@GetMapping("available/{addressId}")
	private boolean ipAddressAvailable(
			@PathVariable String addressId
			) {
		return addyService.ipAddressAvailable(addressId);
	}
	
//	@PutMapping("{addressId}")
//	private Address updateAddressStatus(
//			@PathVariable String addressId,
//			@RequestBody Address address,
//			HttpServletRequest req, 
//			HttpServletResponse res
//			) {
//		addressId = addyService.update()
//		
//		return null;
//	}
	
}
