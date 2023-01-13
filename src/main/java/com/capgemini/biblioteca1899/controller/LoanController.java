package com.capgemini.biblioteca1899.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
					
					model.addAttribute("currentPage", pageNumLoan);
					model.addAttribute("totalPages", page.getTotalPages());
					model.addAttribute("totalItems", page.getTotalElements());
					model.addAttribute("sortField", sortField);
					model.addAttribute("sortDir", sortDirection);
					model.addAttribute("reverseSortDir", sortDirection.equals("asc") ? "desc" : "asc");
					model.addAttribute("listLoans", listLoans);
				
					
			  
			  return "/Loan/loan"; }
	
			  @PostMapping("/saveLoan")
				public String saveLoanPrestamo(Loan loan) {

					this.loanService.saveLoan(loan);

					return "redirect:/loan";
				}
			  
			  @GetMapping("/newLoan") public String showNewBookForm(Model model) { Loan loan
				  =new Loan();
				  model.addAttribute("loan",loan);
				  return "/loan/newLoan"; }
			  
			
			  @GetMapping("/deleteLoan/{idLoan}") public String
			  deleteBook(@PathVariable(value="idLoan") long idLoan) {
			  this.loanService.deleteLoanById(idLoan); return "redirect:/loan"; }
			  
			  @GetMapping("/updateLoan/{idLoan}") public String
			  showFormForUpdate(@PathVariable(value="idLoan") long idLoan, Model model) {
				  Loan loan = loanService.getLoanById(idLoan);
				  model.addAttribute("loan",loan);
			  return "/loan/updateLoan"; }
	 

}
