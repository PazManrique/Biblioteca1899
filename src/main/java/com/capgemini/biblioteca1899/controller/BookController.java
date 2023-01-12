package com.capgemini.biblioteca1899.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.biblioteca1899.model.Book;
import com.capgemini.biblioteca1899.service.book.BookService;




@Controller
public class BookController {
	@Autowired
	private BookService bookService;
	
	
	@GetMapping("/stock")
	public String ViewHomeStock (Model model) {
		return findPaginatedBook(1, "title", "asc", model);
		
	}
	
	@GetMapping("/bookPage/{pageNumBook}")
	public String findPaginatedBook(
			@PathVariable(value="pageNumBook") int pageNumBook, 
			@RequestParam("sortField") String sortField, 
			@RequestParam("sortDirection") String sortDirection, 
			Model model) {
		
		int pageSize = 4;
		Page<Book>  page=bookService.findPaginatedBook(pageNumBook, pageSize, sortField, sortDirection);
		List <Book> listBooks = page.getContent();
		model.addAttribute("currentPage",pageNumBook);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir", sortDirection);
		model.addAttribute("reverseSortDir",sortDirection.equals("asc")? "desc" : "asc");
		model.addAttribute("listBooks",listBooks);
		
		
		
		return "/Book/stock";
	}
	
	  @PostMapping("/saveBook") public String saveBook(@ModelAttribute("book") Book
	  book) {
		  bookService.saveBook(book);
		  return "redirect:/stock";
		  }
	  
	  @GetMapping("/deleteBook/{idBook}") public String
	  deleteBook(@PathVariable(value="idBook") long idBook) {
	  this.bookService.deleteBookById(idBook); return "redirect:/stock"; }
	  
	  @GetMapping("/updateBook/{idBook}") public String
	  showFormForUpdate(@PathVariable(value="idBook") long idBook, Model model) {
		  Book book = bookService.getBookById(idBook);
		  model.addAttribute("book",book);
	  return "/Book/updateBook"; }
	  
	  @GetMapping("/newBook") public String showNewBookForm(Model model) {
		  Book book = new Book();
		  model.addAttribute("book",book);
		  return "/Book/newBook"; }
	  
	  
	  

}
