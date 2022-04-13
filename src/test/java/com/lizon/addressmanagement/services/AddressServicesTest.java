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

@SpringBootTest
class AddressServicesTest {

	@Autowired
	private AddressService addressSvc;
	
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
	
	@Test
	void test_change_ip_address_status_change() {
		Address ipAddress = addressSvc.updateIpAddressStatus("10.0.0.2");
		assertNotNull(ipAddress);
		assertEquals(true, ipAddress.getAvailable());
	}
}
