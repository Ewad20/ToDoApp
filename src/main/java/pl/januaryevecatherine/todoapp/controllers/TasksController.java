package pl.januaryevecatherine.todoapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.januaryevecatherine.todoapp.models.Task;
import pl.januaryevecatherine.todoapp.repositories.TaskRepository;
import pl.januaryevecatherine.todoapp.repositories.UserRepository;

@Controller
@RequiredArgsConstructor
public class TasksController {
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    @GetMapping("/tasks")
    public String getTasksView() {
        return "tasks";
    }

    @GetMapping("/createTask")
    public String createTask() {
        return "task-creator";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String summary, @RequestParam String description, @RequestParam String dateInMillis) {
        taskRepo.save(new Task(summary, description, Long.valueOf(dateInMillis), userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow().getId()));
        return "redirect:/tasks";
    }
}
