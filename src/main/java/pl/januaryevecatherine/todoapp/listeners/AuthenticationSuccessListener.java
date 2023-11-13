package pl.januaryevecatherine.todoapp.listeners;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import pl.januaryevecatherine.todoapp.repositories.TaskRepository;
import pl.januaryevecatherine.todoapp.repositories.UserRepository;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final UserRepository userRepo;
    private final TaskRepository taskRepo;
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        System.out.println(event.getAuthentication().getName());
        taskRepo.findAllByUserId(userRepo.findByUsername(event.getAuthentication().getName()).orElseThrow().getId());
    }
}
