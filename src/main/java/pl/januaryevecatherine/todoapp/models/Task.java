package pl.januaryevecatherine.todoapp.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Getter
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

    public Task(String summary, String description, Long startDateInMillis, Long endDateInMillis, Long userId) {
        this.summary = summary;
        this.description = description;
        this.startDate = new Date(startDateInMillis);
        this.endDate = new Date(endDateInMillis);
        this.userId = userId;
    }
}
