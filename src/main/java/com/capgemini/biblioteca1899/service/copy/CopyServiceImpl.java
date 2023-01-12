package com.capgemini.biblioteca1899.service.copy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.capgemini.biblioteca1899.model.Copy;
import com.capgemini.biblioteca1899.repository.CopyRepository;

@Service
public class CopyServiceImpl implements CopyService {
	// DEPENDENCY INJECTION
			// CursoServiceImpl (CursoRepository cursoRepository){
			// this.curso.Repository=cursoRepository;}
			@Autowired
			private CopyRepository copyRepository;

			@Override
			public List<Copy> getAllCopies() {

				return this.copyRepository.findAll();
			}

			@Override
			public Copy getCopyById(long copyId) {
				// Curso c=this.cursoRepository.findById(id).orElse(null);
				// o usamos el optional
				Optional<Copy> optionalCopy = this.copyRepository.findById(copyId);
				Copy copy = null;
				if (optionalCopy.isPresent()) {
					copy = optionalCopy.get();
				} else {
					throw new RuntimeException("La copia no se encuentra nro: " + copyId);

				}

				return copy;
			}

			@Override
			public void saveCopy(Copy copy) {
				this.copyRepository.save(copy);

			}

			@Override
			public void deleteCopyById(long idCopy) {
				this.copyRepository.deleteById(idCopy);

			}

			@Override
			public Page<Copy> findPaginatedCopy(int pageNumCopy, int pageSize, String sortField, String sortDirection) {
				// if reducido --> variable = (pregunta lógica ? true :false)

				Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? 
						Sort.by(sortField).ascending(): 
						Sort.by(sortField).descending();
				Pageable pageable = PageRequest.of(pageNumCopy -1, pageSize, sort);
				return this.copyRepository.findAll(pageable);
			}

}
