package com.capgemini.biblioteca1899.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	
	@OneToOne
	@JoinColumn(name = "id_book")
	private Book book;

	
	@OneToOne
	@JoinColumn(name = "copy_id")
	private Copy copy;


	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Loan(Long idLoan, Date startDate, Date endDate, Long memberNumber, Book book, Copy copy) {
		super();
		this.idLoan = idLoan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.memberNumber = memberNumber;
		this.book = book;
		this.copy = copy;
	}


	public Long getIdLoan() {
		return idLoan;
	}


	public void setIdLoan(Long idLoan) {
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


	public Long getMemberNumber() {
		return memberNumber;
	}


	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Copy getCopy() {
		return copy;
	}


	public void setCopy(Copy copy) {
		this.copy = copy;
	}
	
	
	
}
