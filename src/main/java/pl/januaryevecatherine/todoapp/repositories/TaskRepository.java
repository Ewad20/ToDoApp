package pl.januaryevecatherine.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.januaryevecatherine.todoapp.models.Task;

import java.util.ArrayList;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    ArrayList<Task> findAllByUserId(Long userId);
}
