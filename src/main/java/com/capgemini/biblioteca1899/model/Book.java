package com.capgemini.biblioteca1899.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBook;
	@Column
	private String title;
	@Column
	private String editorial;
	@Column
	private Integer year;
	@Column
	private String authorName;
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date authorBirthDate;
	@Column
	private String nacionality;
	@Column
	@Enumerated(EnumType.STRING)
	private BookType type;
	@OneToMany (cascade = CascadeType.ALL, mappedBy = "book")
	private List<Copy> copyId;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(Long idBook, String title, String editorial, Integer year, String authorName, Date authorBirthDate,
			String nacionality, BookType type, List<Copy> copyId) {
		super();
		this.idBook = idBook;
		this.title = title;
		this.editorial = editorial;
		this.year = year;
		this.authorName = authorName;
		this.authorBirthDate = authorBirthDate;
		this.nacionality = nacionality;
		this.type = type;
		this.copyId = copyId;
	}

	public Long getIdBook() {
		return idBook;
	}

	public void setIdBook(Long idBook) {
		this.idBook = idBook;
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

	public Date getAuthorBirthDate() {
		return authorBirthDate;
	}

	public void setAuthorBirthDate(Date authorBirthDate) {
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

	public List<Copy> getCopyId() {
		return copyId;
	}

	public void setCopyId(List<Copy> copyId) {
		this.copyId = copyId;
	}

	

	
}
