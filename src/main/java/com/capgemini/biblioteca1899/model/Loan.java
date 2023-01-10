package com.capgemini.biblioteca1899.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="loans")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private Long idReader;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(Long id, Date startDate, Date endDate, Long idReader) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.idReader = idReader;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getIdReader() {
		return idReader;
	}

	public void setIdReader(Long idReader) {
		this.idReader = idReader;
	}
	
	
}
