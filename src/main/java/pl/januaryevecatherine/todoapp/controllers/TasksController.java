package pl.januaryevecatherine.todoapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.januaryevecatherine.todoapp.models.Task;
import pl.januaryevecatherine.todoapp.repositories.TaskRepository;
import pl.januaryevecatherine.todoapp.repositories.UserRepository;

@Controller
@RequiredArgsConstructor
public class TasksController {
    private final TaskRepository taskRepo;
    private final UserRepository userRepo;

    @GetMapping("/tasks")
    public String getTasksView(Model model) {
        model.addAttribute("tasks", taskRepo.findAllByUserId(userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow().getId()));
        return "tasks";
    }

    @GetMapping("/createTask")
    public String createTask() {
        return "task-creator";
    }

    @PostMapping("/addTask")
    public String addTask(@RequestParam String summary, @RequestParam String description, @RequestParam String startDateInMillis, @RequestParam String endDateInMillis) {
        taskRepo.save(new Task(summary, description, Long.valueOf(startDateInMillis), Long.valueOf(endDateInMillis), userRepo.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).orElseThrow().getId()));
        return "redirect:/tasks";
    }

    @GetMapping("/editTask/{taskId}")
    public String editTask(@PathVariable Long taskId, Model model) {
        Task task = taskRepo.findById(taskId).orElseThrow();
        model.addAttribute("task", task);
        return "editTask"; // Use the actual template name for editing tasks
    }

    @GetMapping("/deleteTask/{taskId}")
    public String deleteTask(@PathVariable Long taskId) {
        taskRepo.deleteById(taskId);
        return "redirect:/tasks";
    }

    @PostMapping("/updateTask")
    public String updateTask(@ModelAttribute Task task) {
        taskRepo.updateTask(task.getId(), task.getSummary(), task.getDescription(), task.getStartDate(), task.getEndDate());
        return "redirect:/tasks";
    }
}
