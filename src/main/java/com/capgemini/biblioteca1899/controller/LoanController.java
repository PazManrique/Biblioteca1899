package com.capgemini.biblioteca1899.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.biblioteca1899.model.Book;
import com.capgemini.biblioteca1899.model.Copy;
import com.capgemini.biblioteca1899.model.Loan;
import com.capgemini.biblioteca1899.model.Reader;
import com.capgemini.biblioteca1899.service.book.BookService;
import com.capgemini.biblioteca1899.service.copy.CopyService;
import com.capgemini.biblioteca1899.service.loan.LoanService;
import com.capgemini.biblioteca1899.service.reader.ReaderService;

@Controller
public class LoanController {
	
	@Autowired
	private LoanService loanService;
	@Autowired
	private BookService bookService;
	@Autowired
	private CopyService copyService;
	@Autowired
	private ReaderService readerService;
	
	 @GetMapping("/loan") public String ViewHomeStock (Model model) { return
			  findPaginatedLoan(1, "responsable", "asc", model);
			  
			  }
			  
			  
			  
			  @GetMapping("/loanPage/{pageNumLoan}") public String findPaginatedLoan(
			  
			  @PathVariable(value="pageNumLoan") int pageNumLoan,
			  
			  @RequestParam("sortField") String sortField,
			  
			  @RequestParam("sortDirection") String sortDirection, Model model) {
			  
					int pageSize = 4;
					Page<Loan> page = loanService.findPaginatedLoan(pageNumLoan, pageSize, sortField, sortDirection);
					List<Loan> listLoans = page.getContent();
					List<Copy> listCopies = copyService.getAllCopies();
					List<Book> listBooks = bookService.getAllBooks();
					List<Reader> listReaders = readerService.getAllReaders();
					model.addAttribute("currentPage", pageNumLoan);
					model.addAttribute("totalPages", page.getTotalPages());
					model.addAttribute("totalItems", page.getTotalElements());
					model.addAttribute("sortField", sortField);
					model.addAttribute("sortDir", sortDirection);
					model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
					model.addAttribute("listLoans", listLoans);
					model.addAttribute("listBooks", listBooks);
					model.addAttribute("listReaders", listReaders);
					
			  
			  return "/Loan/loan"; }
	
			  @GetMapping("/loans/saveLoan")
				public String saveLoanPrestamo(Book book, Copy copy,  Reader reader) {

					this.loanService.saveLoan(book, copy, reader);

					return "redirect:/loan";
				}
			  
			
	 
	 

}
