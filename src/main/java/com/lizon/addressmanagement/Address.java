package com.lizon.addressmanagement;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String ipaddress;
	private Boolean acquired;
	
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

	public String getIpaddress() {
		return ipaddress;
	}

	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public Boolean getAcquired() {
		return acquired;
	}

	public void setAcquired(Boolean acquired) {
		this.acquired = acquired;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acquired, id, ipaddress);
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
		return Objects.equals(acquired, other.acquired) && id == other.id && Objects.equals(ipaddress, other.ipaddress);
	}

	@Override
	public String toString() {
		return "Addresses [id=" + id + ", ipaddress=" + ipaddress + ", acquired=" + acquired + "]";
	}
	
}
