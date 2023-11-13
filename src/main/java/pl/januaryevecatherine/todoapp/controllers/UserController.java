package pl.januaryevecatherine.todoapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.januaryevecatherine.todoapp.models.User;
import pl.januaryevecatherine.todoapp.repositories.UserRepository;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repo;

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "user-form";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam String username, @RequestParam String password) {
    repo.save(new User(username, password));
    return "redirect:/";
}
}
