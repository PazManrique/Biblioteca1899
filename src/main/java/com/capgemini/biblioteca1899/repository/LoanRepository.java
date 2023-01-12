package com.capgemini.biblioteca1899.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.biblioteca1899.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
