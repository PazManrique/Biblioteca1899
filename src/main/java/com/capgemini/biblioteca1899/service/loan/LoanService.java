package com.capgemini.biblioteca1899.service.loan;

import java.util.List;

import com.capgemini.biblioteca1899.model.Book;
import com.capgemini.biblioteca1899.model.Copy;
import com.capgemini.biblioteca1899.model.Loan;
import com.capgemini.biblioteca1899.model.Reader;

public interface LoanService {
	
	List<Loan> getAllLoans();

	List<Loan> getLoansByReader(Long memberNumber);

	void deleteLoan(Loan loan);
	
	void saveLoan(Book book , Copy copy, Reader reader);
	
	Boolean canIBorrow(Long copyId);

	void returnLoan(Loan loan);



	

}
