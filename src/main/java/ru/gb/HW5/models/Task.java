package ru.gb.HW5.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Column
    private LocalDateTime dateCreate;
    public enum TaskStatus {
        NOT_STARTED, IN_PROGRESS, COMPLETED
    }
}