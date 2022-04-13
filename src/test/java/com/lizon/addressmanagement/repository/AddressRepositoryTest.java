package com.lizon.addressmanagement.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lizon.addressmanagement.entities.Address;

@SpringBootTest
class AddressRepositoryTest {

	@Autowired
	private AddressRepository addressRepo;
	
	Address ipAddress;

	@AfterEach
	void tearDown() throws Exception {
		ipAddress = null;
	}
	
	@Test
	void test_find_by_id() {
		ipAddress = addressRepo.findById(1);
		assertNotNull(ipAddress);
		assertEquals("10.0.0.1", ipAddress.getIpAddress());
	}
	
	@Test
	void test_find_by_ip_address() {
		ipAddress = addressRepo.findByIpAddress("10.0.0.1");
		assertNotNull(ipAddress);
		assertEquals(1, ipAddress.getId());
	}

}
