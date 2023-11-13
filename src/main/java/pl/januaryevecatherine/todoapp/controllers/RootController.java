package pl.januaryevecatherine.todoapp.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.januaryevecatherine.todoapp.models.UserRole;

@Controller
public class RootController {
    @GetMapping("/")
    public String getRoot() {
        return "root";
    }
}
