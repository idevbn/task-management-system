package com.idevbn.taskmanagementsystem.services;

import com.idevbn.taskmanagementsystem.entities.Task;
import com.idevbn.taskmanagementsystem.repositories.TaskRepository;
import com.idevbn.taskmanagementsystem.services.exceptions.BadRequestException;
import com.idevbn.taskmanagementsystem.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public Task findTaskStatus(Long taskId) {

    Optional<Task> taskOpt = taskRepository.findById(taskId);

    if (!taskOpt.isPresent()) {
      throw new ResourceNotFoundException("Task not found.");
    }

    Task task = taskOpt.get();

    task.setTaskStatus(task.getTaskStatus());

    return task;
  }

  public Task create(Task task) {
    Optional<Task> taskOpt = taskRepository.findByTitle(task.getTitle());

    if (taskOpt.isPresent()) {
      throw new BadRequestException("Task title already exists.");
    }

    return taskRepository.save(task);
  }
}
