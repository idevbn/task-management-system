package com.idevbn.taskmanagementsystem.services;

import com.idevbn.taskmanagementsystem.entities.Task;
import com.idevbn.taskmanagementsystem.repositories.TaskRepository;
import com.idevbn.taskmanagementsystem.services.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

  @Autowired
  private TaskRepository taskRepository;

  public Task findById(Long id) {
    Optional<Task> obj = taskRepository.findById(id);
    return obj.get();
  }

  public Task create(Task task) {
    Optional<Task> taskOpt = taskRepository.findByTitle(task.getTitle());

    if (taskOpt.isPresent()) {
      throw new BadRequestException("Task title already exists.");
    }

    return taskRepository.save(task);
  }
}
