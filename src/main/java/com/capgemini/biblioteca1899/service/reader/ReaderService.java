package com.capgemini.biblioteca1899.service.reader;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.biblioteca1899.model.Reader;



public interface ReaderService {
	List<Reader> getAllReaders();
	Reader getReaderById(long memberNumber);
	void saveReader(Reader reader);
	void deleteReaderById(long memberNumber);
	Page<Reader>findPaginatedReader(int pageNumReader, int pageSize, String sortField, String sortDirection);

}
