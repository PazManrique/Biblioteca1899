package com.capgemini.biblioteca1899.service.loan;

import java.time.LocalDate;
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
import com.capgemini.biblioteca1899.model.Loan;
import com.capgemini.biblioteca1899.model.Reader;
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

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
				Sort.by(sortField).ascending(): 
				Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNumLoan -1, pageSize, sort);
		return this.loanRepository.findAll(pageable);
	}

	



	

	@Override
	public Boolean canIBorrow(Long copyId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveLoan(Loan loan) {
		
		  loan.setStartDate(LocalDate.now());
		  loan.setEndDate(LocalDate.now().plusDays(30));
		 
		
		this.loanRepository.save(loan);
		
	}

	
	@Override
	public void deleteLoanById(Long idLoan) {
		this.loanRepository.deleteById(idLoan);;

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
	
	

	/*
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<Prestamo>
	 * prestamosPorUsuario(Long idUsuario) { var allPrestamos =
	 * this.listarPrestamos(); List<Prestamo> prestamos = new ArrayList<>();
	 * 
	 * for (Prestamo prestamo : allPrestamos) { if
	 * (prestamo.getUsuario().getIdUsuario().equals(idUsuario)) {
	 * prestamos.add(prestamo); } }
	 * 
	 * return prestamos; }
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<Prestamo>
	 * prestamosActivosPorUsuario(Long idUsuario) { var userPrestamos =
	 * this.prestamosPorUsuario(idUsuario); List<Prestamo> prestamos = new
	 * ArrayList<>();
	 * 
	 * for (Prestamo prestamo : userPrestamos) { if (prestamo.getFechaFin() == null)
	 * { prestamos.add(prestamo); } }
	 * 
	 * return prestamos; }
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<Prestamo> prestamosActivos() {
	 * var allPrestamos = this.listarPrestamos(); List<Prestamo> prestamos = new
	 * ArrayList<>();
	 * 
	 * for (Prestamo prestamo : allPrestamos) { if (prestamo.getFechaFin() == null)
	 * { prestamos.add(prestamo); } }
	 * 
	 * return prestamos; }
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public List<Prestamo> prestamosFinalizados()
	 * { var allPrestamos = this.listarPrestamos(); List<Prestamo> prestamos = new
	 * ArrayList<>();
	 * 
	 * for (Prestamo prestamo : allPrestamos) { if (prestamo.getFechaFin() != null)
	 * { prestamos.add(prestamo); } }
	 * 
	 * return prestamos; }
	 * 
	 * @Override public void guardarPrestamo(Libro libro, Copia copia, Usuario
	 * usuario) { Prestamo prestamo = new Prestamo(); prestamo.setLibro(libro);
	 * prestamo.setCopia(copia); prestamo.setUsuario(usuario);
	 * prestamo.setFechaInicio(LocalDate.now());
	 * copia.setEstado(EstadoCopia.PRESTADO);
	 * 
	 * this.prestamosRepository.save(prestamo); }
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Prestamo buscarPrestamo(Prestamo
	 * prestamo) { return
	 * this.prestamosRepository.findById(prestamo.getIdPrestamo()).orElse(null); }
	 * 
	 * @Override
	 * 
	 * @Transactional public void devolucion(Prestamo prestamo) {
	 * prestamo.setFechaFin(LocalDate.now());
	 * prestamo.getCopia().setEstado(EstadoCopia.BIBLIOTECA); }
	 * 
	 * @Override
	 * 
	 * @Transactional(readOnly = true) public Boolean hayPrestamosPorCopia(Long
	 * idCopia) { var allPrestamos = this.listarPrestamos(); var index = 0; boolean
	 * tienePrestamos = false;
	 * 
	 * while (index < allPrestamos.size() && !tienePrestamos) { if
	 * (allPrestamos.get(index).getCopia().getIdCopia().equals(idCopia)) {
	 * tienePrestamos = true; } index++; }
	 * 
	 * return tienePrestamos; }
	 * 
	 * @Override
	 * 
	 * @Transactional public void eliminar(Prestamo prestamo) {
	 * this.prestamosRepository.delete(prestamo); }
	 */

}
