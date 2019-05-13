package ua.step.bookshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.step.bookshop.models.User;
import ua.step.bookshop.repositories.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository repos;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", repos.findAll());
        return "usersView/users";
    }

    @GetMapping("/addUser")
    public String addUser(){
        return "usersView/addUser";
    }

    @PostMapping("/addUser")
    public String addUserSubmit(@ModelAttribute("user") User user){
        repos.save(user);
        return "redirect:/users";
    }

    @GetMapping("/updateUser/{id}")
    public String update(@PathVariable("id") Short id, Model model){
        model.addAttribute("user", repos.findById(id));
        return "usersView/updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute("user") User user){
        User updateUser = repos.getOne(user.getId());
        updateUser.setName(user.getName());
        repos.save(updateUser);
        return "redirect:/showUser/"+updateUser.getId();
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") Short id){
        repos.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/showUser/{id}")
    public String getById(@PathVariable("id") Short id, Model model){
        model.addAttribute("user", repos.findById(id));
        return "usersView/showUser";
    }
}
