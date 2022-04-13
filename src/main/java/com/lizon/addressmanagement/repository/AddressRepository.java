package com.lizon.addressmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lizon.addressmanagement.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	
	Address findById(int addressId);
	
	Address findByIpAddress(String ipAddress);

}
