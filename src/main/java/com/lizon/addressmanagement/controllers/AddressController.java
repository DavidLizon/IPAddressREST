package com.lizon.addressmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lizon.addressmanagement.Address;
import com.lizon.addressmanagement.services.AddressService;

@RestController
public class AddressController {

	@Autowired
	private AddressService service;
	
	@GetMapping("addresses")
	private List<Address> list() {
		return service.listAll();
	}
	
}
