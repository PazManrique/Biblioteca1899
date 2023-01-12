package com.capgemini.biblioteca1899.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	
	 @ManyToOne(fetch = FetchType.LAZY, optional = false)
	  @JoinColumn(name = "member_number", nullable = false)
	 private Reader reader;
	
	
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
