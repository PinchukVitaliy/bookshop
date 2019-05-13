package ua.step.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.step.bookshop.models.Publish;
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

	@GetMapping("/addPublish")
	public String addPublish(){
		return "publishiesView/addPublish";
	}

	@PostMapping("/addPublish")
	public String addPublishSubmit(@ModelAttribute("publish") Publish publish){
		repos.save(publish);
		return "redirect:/publishies";
	}

	@GetMapping("/updatePublish/{id}")
	public String update(@PathVariable("id") Short id, Model model){
		model.addAttribute("publish", repos.findById(id));
		return "publishiesView/updatePublish";
	}

	@PostMapping("/updatePublish")
	public String updatePublish(@ModelAttribute("genre") Publish publish){
		Publish updatePublish = repos.getOne(publish.getId());
		updatePublish.setName(publish.getName());
		repos.save(updatePublish);
		return "redirect:/showPublish/"+updatePublish.getId();
	}

	@GetMapping("/deletePublish/{id}")
	public String deletePublish(@PathVariable("id") Short id){
		repos.deleteById(id);
		return "redirect:/publishies";
	}

	@GetMapping("/showPublish/{id}")
	public String getById(@PathVariable("id") Short id, Model model){
		model.addAttribute("publish", repos.findById(id));
		return "publishiesView/showPublish";
	}
}
