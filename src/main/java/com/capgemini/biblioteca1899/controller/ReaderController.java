package com.capgemini.biblioteca1899.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.capgemini.biblioteca1899.model.Reader;
import com.capgemini.biblioteca1899.service.reader.ReaderService;



@Controller
public class ReaderController {
	
	@Autowired
	private ReaderService readerService;
	
	@GetMapping("/reader")
	public String ViewHomeReader (Model model) {
		return findPaginatedReader(1, "name", "asc", model);
		
	}
	
	@GetMapping("/readerPage/{pageNumReader}")
	public String findPaginatedReader(
			@PathVariable(value="pageNumReader") int pageNumReader, 
			@RequestParam("sortField") String sortField, 
			@RequestParam("sortDirection") String sortDirection, 
			Model model) {
		
		int pageSize = 4;
		Page<Reader>  page=readerService.findPaginatedReader(pageNumReader, pageSize, sortField, sortDirection);
		List <Reader> listReaders = page.getContent();
		model.addAttribute("currentPage",pageNumReader);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir", sortDirection);
		model.addAttribute("reverseSortDir",sortDirection.equals("asc")? "desc" : "asc");
		model.addAttribute("listReaders",listReaders);
		
		
		
		return "Reader/reader";
	}
	
	  @PostMapping("/saveReader") public String saveReader(@ModelAttribute("reader") Reader
	  reader) { readerService.saveReader(reader); return "redirect:/reader"; }
	  
	  @GetMapping("/delete/{memberNumber}") public String
	  deleteCurso(@PathVariable(value="memberNumber") long memberNumber) {
	  this.readerService.deleteReaderById(memberNumber); return "redirect:/"; }
	  
	  @GetMapping("/update/{memberNumber}") public String
	  showFormForUpdate(@PathVariable(value="memberNumber") long memberNumber, Model model) { Reader
	  reader =readerService.getReaderById(memberNumber); model.addAttribute("reader",reader);
	  return "Reader/updateReader"; }
	  
	  @GetMapping("/newReader") public String showNewReaderForm(Model model) { Reader reader
	  =new Reader(); model.addAttribute("reader",reader); return "Reader/newReader"; }
	  
	  
	  
	  
	  
	  
	  
	  @GetMapping("/loan") public String ViewLoan () { return "loan";
	  
	  }
	  
	 
	  
	  @GetMapping("/newLoan") public String ViewNewLoan () { return "newLoan";
	  
	  }
	  
	  @GetMapping("/") public String ViewNewReader() { return "index";
	  
	  }
	  

	  
	
	


}
