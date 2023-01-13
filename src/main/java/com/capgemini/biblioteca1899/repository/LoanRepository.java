package com.capgemini.biblioteca1899.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.biblioteca1899.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
	List<Loan> getLoansByMemberNumber(long memberNumber);
}
