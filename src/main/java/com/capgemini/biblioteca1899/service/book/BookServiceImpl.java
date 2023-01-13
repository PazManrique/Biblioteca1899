package com.capgemini.biblioteca1899.service.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.biblioteca1899.model.Book;
import com.capgemini.biblioteca1899.model.Copy;
import com.capgemini.biblioteca1899.repository.BookRepository;
import com.capgemini.biblioteca1899.repository.CopyRepository;


@Service
public class BookServiceImpl implements BookService {
	// DEPENDENCY INJECTION
	// CursoServiceImpl (CursoRepository cursoRepository){
	// this.curso.Repository=cursoRepository;}
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CopyRepository copyRepository;

	@Override
	public List<Book> getAllBooks() {

		return this.bookRepository.findAll();
	}

	@Override
	public Book getBookById(long idBook) {
		// Curso c=this.cursoRepository.findById(id).orElse(null);
		// o usamos el optional
		Optional<Book> optionalBook = this.bookRepository.findById(idBook);
		Book book = null;
		if (optionalBook.isPresent()) {
			book = optionalBook.get();
		} else {
			throw new RuntimeException("El libro no se encuentra nro: " + idBook);

		}

		return book;
	}

	@Override
	public void saveBookCopy(Book book, List<Copy> idCopy) {
		Book book2 = new Book();
        book2.setCopyId(idCopy);
		this.bookRepository.save(book2);

	}
	
	@Override
	public void saveBook(Book book) {
		this.bookRepository.save(book);

	}
	

	@Override
	public void deleteBookById(long idBook) {
		this.bookRepository.deleteById(idBook);

	}

	@Override
	public Page<Book> findPaginatedBook(int pageNumBook, int pageSize, String sortField, String sortDirection) {
		// if reducido --> variable = (pregunta lógica ? true :false)

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending(): 
				Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNumBook -1, pageSize, sort);
		return this.bookRepository.findAll(pageable);
	}


}
