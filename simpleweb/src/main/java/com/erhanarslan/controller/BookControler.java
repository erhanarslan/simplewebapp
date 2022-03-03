package com.erhanarslan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erhanarslan.repository.BookRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class BookControler {
	
	private final BookRepo bookrepo;
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		model.addAttribute("books", bookrepo.findAll());
		return "books/list";
	}

}
