package com.capgemini.biblioteca1899.service.loan;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.biblioteca1899.model.Book;
import com.capgemini.biblioteca1899.model.Copy;
import com.capgemini.biblioteca1899.model.Loan;
import com.capgemini.biblioteca1899.model.Reader;

public interface LoanService {
	
	List<Loan> getAllLoans();

	Loan getLoanById(long idLoan);
	
	List<Loan> getLoansByMemberNumber(long memberNumber);

	void deleteLoanById(Long idLoan);
	
	
	
	void saveLoan(Loan loan);
	
	Boolean canIBorrow(Long copyId);


	
	Page<Loan> findPaginatedLoan(int pageNumLoan, int pageSize, String sortField, String sortDirection);



	

}
