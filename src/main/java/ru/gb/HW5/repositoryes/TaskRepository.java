package ru.gb.HW5.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.HW5.models.Task;

import java.util.List;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTasksByStatus(Task.TaskStatus status);

}