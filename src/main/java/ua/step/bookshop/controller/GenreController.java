package ua.step.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ua.step.bookshop.models.Genre;
import ua.step.bookshop.repositories.GenreRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GenreController {
	@Autowired
	private GenreRepository repos;
	
	@GetMapping("/genres")
	public String getGeneres(Model model) {
		model.addAttribute("genres", repos.findAll());

		//ArrayList<Genre> genre = (ArrayList<Genre>) repos.findAll();
		System.out.printf("start");
		for(Genre g : repos.findAll()){
			System.out.printf("one");
			System.out.println(g.getName());
		}
		System.out.printf("end");
		return "genres";
	}
}
