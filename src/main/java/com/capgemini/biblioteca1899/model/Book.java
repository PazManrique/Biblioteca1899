package com.capgemini.biblioteca1899.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String title;
	@Column
	private String editorial;
	@Column
	private Integer year;
	@Column
	private String authorName;
	@Column
	private LocalDate authorBirthDate;
	@Column
	private String nacionality;
	@Column
	@Enumerated(EnumType.STRING)
	private BookType type;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="copy_id", nullable=true)
	private Copy copyId;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Book(Long id, String title, String editorial, Integer year, String authorName, LocalDate authorBirthDate,
			String nacionality, BookType type, Copy copyId) {
		super();
		this.id = id;
		this.title = title;
		this.editorial = editorial;
		this.year = year;
		this.authorName = authorName;
		this.authorBirthDate = authorBirthDate;
		this.nacionality = nacionality;
		this.type = type;
		this.copyId = copyId;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public LocalDate getAuthorBirthDate() {
		return authorBirthDate;
	}

	public void setAuthorBirthDate(LocalDate authorBirthDate) {
		this.authorBirthDate = authorBirthDate;
	}

	public String getNacionality() {
		return nacionality;
	}

	public void setNacionality(String nacionality) {
		this.nacionality = nacionality;
	}

	public BookType getType() {
		return type;
	}

	public void setType(BookType type) {
		this.type = type;
	}

	public Copy getCopyId() {
		return copyId;
	}

	public void setCopyId(Copy copyId) {
		this.copyId = copyId;
	}

	
	
}
