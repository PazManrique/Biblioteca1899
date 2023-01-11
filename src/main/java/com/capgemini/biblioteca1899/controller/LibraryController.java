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
public class LibraryController {
	
	@Autowired
	private ReaderService readerService;
	
	@GetMapping("/reader")
	public String ViewHomeReader (Model model) {
		return findPaginated(1, "name", "asc", model);
		
	}
	
	@GetMapping("/page/{pageNum}")
	public String findPaginated(
			@PathVariable(value="pageNum") int pageNum, 
			@RequestParam("sortField") String sortField, 
			@RequestParam("sortDirection") String sortDirection, 
			Model model) {
		
		int pageSize = 4;
		Page<Reader>  page=readerService.findPaginated(pageNum, pageSize, sortField, sortDirection);
		List <Reader> listReaders = page.getContent();
		model.addAttribute("currentPage",pageNum);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir", sortDirection);
		model.addAttribute("reverseSortDir",sortDirection.equals("asc")? "desc" : "asc");
		model.addAttribute("listCourses",listReaders);
		
		
		
		return "reader";
	}
	
	  @PostMapping("/save") public String saveCurso(@ModelAttribute("reader") Reader
	  reader) { readerService.saveReader(reader); return "redirect:/"; }
	  
	  @GetMapping("/delete/{memberNumber}") public String
	  deleteCurso(@PathVariable(value="memberNumber") long memberNumber) {
	  this.readerService.deleteReaderById(memberNumber); return "redirect:/"; }
	  
	  @GetMapping("/update/{memberNumber}") public String
	  showFormForUpdate(@PathVariable(value="memberNumber") long memberNumber, Model model) { Reader
	  reader =readerService.getReaderById(memberNumber); model.addAttribute("reader",reader);
	  return "updateReader"; }
	  
	  @GetMapping("/newReader") public String showNewReaderForm(Model model) { Reader reader
	  =new Reader(); model.addAttribute("reader",reader); return "newReader"; }
	  
	  
	  
	  
	  
	  
	  
	  @GetMapping("/loan") public String ViewLoan () { return "loan";
	  
	  }
	  
	  @GetMapping("/newBook") public String ViewNewBook () { return "newBook";
	  
	  }
	  
	  @GetMapping("/newLoan") public String ViewNewLoan () { return "newLoan";
	  
	  }
	  
	  @GetMapping("/") public String ViewNewReader() { return "index";
	  
	  }
	  

	  
	  @GetMapping("/stock") public String ViewStock () { return "stock";
	  
	  }
	 
	


}
