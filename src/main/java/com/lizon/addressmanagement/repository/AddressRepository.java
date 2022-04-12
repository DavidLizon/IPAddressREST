package com.lizon.addressmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lizon.addressmanagement.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
