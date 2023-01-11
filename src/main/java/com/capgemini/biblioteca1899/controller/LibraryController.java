package com.capgemini.biblioteca1899.controller;


import org.springframework.web.bind.annotation.GetMapping;



public class LibraryController {
	
	
	@GetMapping("/stock")
	public String ViewStock () {
		return "Stock";
		
	}

}
