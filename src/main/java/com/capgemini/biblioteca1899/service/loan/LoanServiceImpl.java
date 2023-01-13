package com.capgemini.biblioteca1899.service.loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.capgemini.biblioteca1899.model.Loan;
import com.capgemini.biblioteca1899.repository.LoanRepository;

@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	LoanRepository loanRepository;

	@Override
	public List<Loan> getAllLoans() {

		return this.loanRepository.findAll();
	}

	@Override
	public Page<Loan> findPaginatedLoan(int pageNumLoan, int pageSize, String sortField, String sortDirection) {
		// if reducido --> variable = (pregunta lógica ? true :false)

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNumLoan - 1, pageSize, sort);
		return this.loanRepository.findAll(pageable);
	}

	@Override
	public Boolean canIBorrow(Long copyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteLoanById(Long idLoan) {
		this.loanRepository.deleteById(idLoan);
		;

	}

	@Override
	public Loan getLoanById(long idLoan) {
		// Curso c=this.cursoRepository.findById(id).orElse(null);
		// o usamos el optional
		Optional<Loan> optionalLoan = this.loanRepository.findById(idLoan);
		Loan loan = null;
		if (optionalLoan.isPresent()) {
			loan = optionalLoan.get();
		} else {
			throw new RuntimeException("El prestamo no se encuentra nro: " + idLoan);

		}

		return loan;
	}

	@Override

	public List<Loan> getLoansByMemberNumber(long memberNumber) {

		var allLoans = this.getAllLoans();
		List<Loan> loans = new ArrayList<>();

		for (Loan loan : allLoans) {
			if (loan.getMemberNumber().equals(memberNumber)) {
				loans.add(loan);
			}
		}

		return loans;
	}

	@Override
	public void saveLoan(Loan loan) {

		loan.setStartDate(LocalDate.now());
		loan.setEndDate(LocalDate.now().plusDays(30));
		this.loanRepository.save(loan);
	}

}

