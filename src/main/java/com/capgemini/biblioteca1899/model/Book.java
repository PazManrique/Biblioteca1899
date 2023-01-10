package com.capgemini.biblioteca1899.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate authorBirthDate;
	@Column
	private String nacionality;
	@Column
	private String bookType;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long id, String title, String editorial, Integer year, String authorName, LocalDate authorBirthDate,
			String nacionality, String bookType) {
		super();
		this.id = id;
		this.title = title;
		this.editorial = editorial;
		this.year = year;
		this.authorName = authorName;
		this.authorBirthDate = authorBirthDate;
		this.nacionality = nacionality;
		this.bookType = bookType;
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

	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
	
	
	
}
