package com.capgemini.biblioteca1899.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="readers")
public class Reader {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberNumber;
	@Column
	private String name;
	@Column
	private String phone;
	@Column
	private String address;
	
	
	
	public Reader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reader(Long memberNumber, String name, String phone, String address) {
		super();
		this.memberNumber = memberNumber;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}

	public Long getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	
	
	
}
