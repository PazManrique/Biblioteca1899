package com.capgemini.biblioteca1899.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LibraryController {
	
	
	@GetMapping("/newReader")
	public String ViewStock () {
		return "newReader";
		
	}

}
