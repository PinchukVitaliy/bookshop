package ua.step.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.step.bookshop.models.Genre;
import ua.step.bookshop.repositories.GenreRepository;

import java.util.Optional;

@Controller
public class GenreController {
	@Autowired
	private GenreRepository repos;
	
	@GetMapping("/genres")
	public String getGeneres(Model model) {
		model.addAttribute("genres", repos.findAll());
		return "genresView/genres";
	}

	@GetMapping("/addGenre")
	public String addGenre(){
		return "genresView/addGenre";
	}

	@PostMapping("/addGenre")
	public String addGenreSubmit(@ModelAttribute("genre") Genre genre){
		repos.save(genre);
		return "redirect:/genres";
	}

	@GetMapping("/updateGenre/{id}")
	public String update(@PathVariable("id") Short id, Model model){
		model.addAttribute("genre", repos.findById(id));
		return "genresView/updateGenre";
	}

	@PostMapping("/updateGenre")
	public String updateGenre(@ModelAttribute("genre") Genre genre){
		Genre updateGenre = repos.getOne(genre.getId());
		updateGenre.setName(genre.getName());
		repos.save(updateGenre);
		return "redirect:/showGenre/"+updateGenre.getId();
	}

	@GetMapping("/deleteGenre/{id}")
	public String deleteGenre(@PathVariable("id") Short id){
		repos.deleteById(id);
		return "redirect:/genres";
	}

	@GetMapping("/showGenre/{id}")
	public String getById(@PathVariable("id") Short id, Model model){
		model.addAttribute("genre", repos.findById(id));
		return "genresView/showGenre";
	}
}
