package com.capgemini.biblioteca1899.model;

import java.time.LocalDate;
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
@Table(name = "loans")
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLoan;
	@Column
	private LocalDate startDate;

	@Column
	private LocalDate endDate;

	@Column
	private String responsable;

	@Column
	private Long memberNumber;

	@Column
	private Long idBook;

	@Column
	private Long copyId;

	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loan(Long idLoan, LocalDate startDate, LocalDate endDate, String responsable, Long memberNumber, Long idBook,
			Long copyId) {
		super();
		this.idLoan = idLoan;
		this.startDate = startDate;
		this.endDate = endDate;
		this.responsable = responsable;
		this.memberNumber = memberNumber;
		this.idBook = idBook;
		this.copyId = copyId;
	}

	public Long getIdLoan() {
		return idLoan;
	}

	public void setIdLoan(Long idLoan) {
		this.idLoan = idLoan;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public Long getMemberNumber() {
		return memberNumber;
	}

	public void setMemberNumber(Long memberNumber) {
		this.memberNumber = memberNumber;
	}

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
	}

	public Long getCopyId() {
		return copyId;
	}

	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}

}
