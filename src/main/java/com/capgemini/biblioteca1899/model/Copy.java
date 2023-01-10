package com.capgemini.biblioteca1899.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	private Long id;
	@Column
	@Enumerated(EnumType.STRING)
	private CopyState state;
	
	
	public Copy() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Copy(Long copyId, Long id, CopyState state) {
		super();
		this.copyId = copyId;
		this.id = id;
		this.state = state;
	}


	public Long getCopyId() {
		return copyId;
	}


	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public CopyState getState() {
		return state;
	}


	public void setState(CopyState state) {
		this.state = state;
	}

	
	
}
