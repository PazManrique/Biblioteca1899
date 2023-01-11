package com.capgemini.biblioteca1899.service.book;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.biblioteca1899.model.Book;


public interface BookService {
	List<Book> getAllBooks();
	Book getBookById(long idBook);
	void saveBook(Book book);
	void deleteBookById(long idBook);
	Page<Book>findPaginatedBook(int pageNumBook, int pageSize, String sortField, String sortDirection);

}



