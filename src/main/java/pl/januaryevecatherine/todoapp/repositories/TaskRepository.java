package pl.januaryevecatherine.todoapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.januaryevecatherine.todoapp.models.Task;

import java.sql.Date;
import java.util.ArrayList;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Modifying
    @Query("update Task t set t.summary = ?2, t.description = ?3, t.startDate = ?4, t.endDate = ?5  where t.id = ?1")
    void updateTask(Long taskId, String summary, String description, Date startDate, Date endDate);
    ArrayList<Task> findAllByUserId(Long userId);
}
