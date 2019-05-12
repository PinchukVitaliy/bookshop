package ua.step.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.step.bookshop.repositories.PublisherRepository;

@Controller
public class PublisherController {
	@Autowired
	private PublisherRepository repos;
	
	@GetMapping("/publishies")
	public String getGeneres(Model model) {
		model.addAttribute("publishies", repos.findAll());
		return "publishiesView/publishies";
	}
}
