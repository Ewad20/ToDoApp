package pl.januaryevecatherine.todoapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.januaryevecatherine.todoapp.models.User;
import pl.januaryevecatherine.todoapp.repositories.UserRepository;

@RestController
@RequiredArgsConstructor
public class usernew {
    private final UserRepository repo;

    @GetMapping("/new")
    public void addUser() {
        repo.save(new User("jan", "january"));
    }
}
