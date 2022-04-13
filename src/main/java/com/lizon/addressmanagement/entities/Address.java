package com.lizon.addressmanagement.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "ip_address")
	private String ipAddress;
	private Boolean available;
	
	/* ----------------------------------------------------------------------------
	Constructors
	---------------------------------------------------------------------------- */
	public Address() {
		super();
	}

	/* ----------------------------------------------------------------------------
	Getters/Setters
	---------------------------------------------------------------------------- */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, id, ipAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(available, other.available) && id == other.id && Objects.equals(ipAddress, other.ipAddress);
	}

	@Override
	public String toString() {
		return "Addresses [id=" + id + ", ipAddress=" + ipAddress + ", available=" + available + "]";
	}
	
}
