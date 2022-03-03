package com.erhanarslan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.erhanarslan.repository.AuthorRepo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class AuthorController {
	
	private AuthorRepo authorrepo;
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		
		model.addAttribute("authors", authorrepo.findAll());
		return "/authors/list";
		
	}
}
