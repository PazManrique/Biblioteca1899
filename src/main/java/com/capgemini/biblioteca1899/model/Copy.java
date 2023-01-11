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
	private Long idBook;
	@Column
	@Enumerated(EnumType.STRING)
	private CopyState state;
	
	
	public Copy() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Copy(Long copyId, Long idBook, CopyState state) {
		super();
		this.copyId = copyId;
		this.idBook = idBook;
		this.state = state;
	}


	public Long getCopyId() {
		return copyId;
	}


	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}


	public Long getId() {
		return idBook;
	}


	public void setId(Long idBook) {
		this.idBook = idBook;
	}


	public CopyState getState() {
		return state;
	}


	public void setState(CopyState state) {
		this.state = state;
	}

	
	
}
