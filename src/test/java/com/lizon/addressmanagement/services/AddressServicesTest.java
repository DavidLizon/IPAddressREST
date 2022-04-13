package com.lizon.addressmanagement.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lizon.addressmanagement.entities.Address;
import com.lizon.addressmanagement.repository.AddressRepository;

@SpringBootTest
class AddressServicesTest {

	@Autowired
	private AddressService addressSvc;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@AfterEach
	void tearDown() throws Exception {
		addressSvc = null;
	}

	@Test
	void test_list_all_addresses() {
		List<Address> allAddresses = addressSvc.listAll();
		assertNotNull(allAddresses);
		assertTrue(allAddresses.size() > 1);
	}

	@Test
	void test_find_ip_address() {
		Address ipAddress = addressSvc.findIPAddress("10.0.0.1");
		assertNotNull(ipAddress);
		assertEquals(1, ipAddress.getId());
	}
	
	@Test
	void test_ip_address_status() {
		String ipAddress = addressSvc.ipAddressStatus("10.0.0.1");
		assertNotNull(ipAddress);
		assertEquals("10.0.0.1: available", ipAddress);
	}
	
	
	// Test stores availability of address 10.0.0.2, changes it's availability, and reverts the 
	// availability back to the initial state after the test is complete.
	@Test
	void test_change_ip_address_status_change() {
		Address ipAddress = addressSvc.findIPAddress("10.0.0.2");
		boolean initialStatus = ipAddress.getAvailable();
		
		ipAddress.setAvailable(false);
		addressRepo.save(ipAddress);
		ipAddress = addressSvc.updateIpAddressStatus("10.0.0.2");
		assertNotNull(ipAddress);
		assertEquals(true, ipAddress.getAvailable());
		
		ipAddress.setAvailable(initialStatus);
		addressRepo.save(ipAddress);
	}
	
	@Test
	void test_add_ip_address_range() {
		List<Address> addressRange = addressSvc.addAddresses("10.0.0.10", "20");
		assertNotNull(addressRange);
		assertTrue(addressRange.size() == 11);
		assertEquals(true, addressSvc.findIPAddress("10.0.0.10").getAvailable());
		assertEquals(true, addressSvc.findIPAddress("10.0.0.20").getAvailable());
	}
}
