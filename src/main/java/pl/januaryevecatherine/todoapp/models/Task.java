package pl.januaryevecatherine.todoapp.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "summary")
    private String summary;
    @Column(name = "description")
    private String description;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "end_date")
    private Date endDate;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "category_id")
    private Long categoryId;
    @Column(name = "status")
    private Long statusId;

    public Task(String summary, String description, Long dateInMillis, Long userId) {
        this.summary = summary;
        this.description = description;
        this.startDate = new Date(System.currentTimeMillis());
        this.endDate = new Date(dateInMillis);
        this.userId = userId;
    }
}
