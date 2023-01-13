package com.capgemini.biblioteca1899.model;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="copies")
public class Copy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long copyId;
	

	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn (name="ID_BOOK", nullable=true)
	private Book book;

	
	@Column
	@Enumerated(EnumType.STRING)
	private CopyState state;

	public Copy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Copy(Long copyId, Book book, CopyState state) {
		super();
		this.copyId = copyId;
		this.book = book;
		this.state = state;
	}

	public Long getCopyId() {
		return copyId;
	}

	public void setCopyId(Long copyId) {
		this.copyId = copyId;
	}

	public Book getIdBook() {
		return book;
	}

	public void setIdBook(Book book) {
		this.book = book;
	}

	public CopyState getState() {
		return state;
	}

	public void setState(CopyState state) {
		this.state = state;
	}
	
}
