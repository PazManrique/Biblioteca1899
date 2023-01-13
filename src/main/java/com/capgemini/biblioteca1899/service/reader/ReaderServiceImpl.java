package com.capgemini.biblioteca1899.service.reader;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.biblioteca1899.model.Reader;
import com.capgemini.biblioteca1899.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements ReaderService {

	// DEPENDENCY INJECTION
	// CursoServiceImpl (CursoRepository cursoRepository){
	// this.curso.Repository=cursoRepository;}
	@Autowired
	private ReaderRepository readerRepository;

	@Override
	public List<Reader> getAllReaders() {

		return this.readerRepository.findAll();
	}

	@Override
	public Reader getReaderById(long memberNumber) {
		// Curso c=this.cursoRepository.findById(id).orElse(null);
		// o usamos el optional
		Optional<Reader> optionalReader = this.readerRepository.findById(memberNumber);
		Reader reader = null;
		if (optionalReader.isPresent()) {
			reader = optionalReader.get();
		} else {
			throw new RuntimeException("El lector no se encuentra nro: " + memberNumber);

		}

		return reader;
	}

	@Override
	public void saveReader(Reader reader) {
		this.readerRepository.save(reader);

	}

	@Override
	public void deleteReaderById(long memberNumber) {
		this.readerRepository.deleteById(memberNumber);

	}

	@Override
	public Page<Reader> findPaginatedReader(int pageNumReader, int pageSize, String sortField, String sortDirection) {
		// if reducido --> variable = (pregunta lógica ? true :false)

		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNumReader - 1, pageSize, sort);
		return this.readerRepository.findAll(pageable);
	}

}
