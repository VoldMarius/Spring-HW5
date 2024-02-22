package ru.gb.HW5.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.HW5.models.Task;
import ru.gb.HW5.repositoryes.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    private Task saveTask(Task task) {
        return repository.save(task);
    }

    public Task createTask(String description) {
        Task newTask = new Task();
        newTask.setDescription(description);
        newTask.setStatus(Task.TaskStatus.NOT_STARTED);
        newTask.setDateCreate(LocalDateTime.now());
        return saveTask(newTask);
    }

    public Task updateTaskStatus(Long id) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (task.getStatus().equals(Task.TaskStatus.NOT_STARTED)) {
                task.setStatus(Task.TaskStatus.IN_PROGRESS);
            } else if (task.getStatus().equals(Task.TaskStatus.IN_PROGRESS)) {
                task.setStatus(Task.TaskStatus.COMPLETED);
            }
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    public List<Task> findTaskByStatus(Task.TaskStatus status) {
        return repository.findTasksByStatus(status);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }
}