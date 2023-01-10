package com.capgemini.biblioteca1899.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="copies")
public class Copy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long copyId;
	@Column
	private String copyState;
	
	
	public Copy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Copy(Long copyId, String copyState) {
		super();
		this.copyId = copyId;
		this.copyState = copyState;
	}

	public Long getcopyId() {
		return copyId;
	}

	public void setcopyId(Long copyId) {
		this.copyId = copyId;
	}

	public String getCopyState() {
		return copyState;
	}

	public void setCopyState(String copyState) {
		this.copyState = copyState;
	}
	
}
