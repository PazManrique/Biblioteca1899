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
	private Long idLoan;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private Long memberNumber;
	
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(Long idLoan, Date startDate, Date endDate, Long memberNumber) {
		super();
		this.idLoan = idLoan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.memberNumber = memberNumber;
	}

	public Long getIdLoan() {
		return idLoan;
	}

	public void setId(Long idLoan) {
		this.idLoan = idLoan;
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

	public Long getmemberNumber() {
		return memberNumber;
	}

	public void setmemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}
	
	
}
