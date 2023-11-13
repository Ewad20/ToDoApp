package pl.januaryevecatherine.todoapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CreditsController {
    @GetMapping("/credits")
    public String getCredits() {
        return "credits";
    }
}
