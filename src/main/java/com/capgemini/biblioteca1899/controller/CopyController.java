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

import com.capgemini.biblioteca1899.model.Copy;
import com.capgemini.biblioteca1899.service.book.BookService;
import com.capgemini.biblioteca1899.service.copy.CopyService;

@Controller
public class CopyController {
	@Autowired
	private CopyService copyService;
	

	
	@GetMapping("/copy")
	public String ViewHomeCopy (Model model) {
		return findPaginatedCopy(1, "state", "asc", model);
		
	}
	
	/*
	 * @GetMapping("/copy/{idBook}") public String ViewCopyByIdBook (Model model,
	 * Copy idBook){ return copyService.getCopyByIdBook(idBook); }
	 */
	
	@GetMapping("/copyPage/{pageNumCopy}")
	public String findPaginatedCopy(
			@PathVariable(value="pageNumCopy") int pageNumCopy, 
			@RequestParam("sortField") String sortField, 
			@RequestParam("sortDirection") String sortDirection, 
			Model model) {
		
		int pageSize = 4;
		Page<Copy>  page=copyService.findPaginatedCopy(pageNumCopy, pageSize, sortField, sortDirection);
		List <Copy> listCopies = page.getContent();
		model.addAttribute("currentPage",pageNumCopy);
		model.addAttribute("totalPages",page.getTotalPages());
		model.addAttribute("totalItems",page.getTotalElements());
		model.addAttribute("sortField",sortField);
		model.addAttribute("sortDir", sortDirection);
		model.addAttribute("reverseSortDir",sortDirection.equals("asc")? "desc" : "asc");
		model.addAttribute("listCopies",listCopies);
		
		
		
		return "/Copy/copy";
	}
	
	  @PostMapping("/saveCopy") public String saveBook(@ModelAttribute("copy") Copy
	  copy) {
		  copyService.saveCopy(copy);return "redirect:/copy"; }
	  
	  @GetMapping("/deleteCopy/{copyId}") public String
	  deleteCopy(@PathVariable(value="copyId") long copyId) {
	  this.copyService.deleteCopyById(copyId); return "redirect:/copy"; }
	  
	  @GetMapping("/updateCopy/{copyId}") public String
	  showFormForUpdate(@PathVariable(value="copyId") long copyId, Model model) { Copy
	  copy =copyService.getCopyById(copyId); model.addAttribute("copy",copy);
	  return "/Book/updateCopy"; }
	  
	  @GetMapping("/newCopy") public String showNewBookForm(Model model) { Copy copy
	  =new Copy(); model.addAttribute("copy",copy); return "/Copy/newCopy"; }
	  
}
