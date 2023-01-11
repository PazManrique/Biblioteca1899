package com.capgemini.biblioteca1899.service.copy;

import java.util.List;

import org.springframework.data.domain.Page;

import com.capgemini.biblioteca1899.model.Copy;

public interface CopyService {
	List<Copy> getAllCopies();
	Copy getCopyById(long copyId);
	void saveCopy(Copy copy);
	void deleteCopyById(long copyId);
	Page<Copy>findPaginatedCopy(int pageNumCopy, int pageSize, String sortField, String sortDirection);
}