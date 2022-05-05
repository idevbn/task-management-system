package com.idevbn.taskmanagementsystem.services;

import com.idevbn.taskmanagementsystem.entities.Task;
import com.idevbn.taskmanagementsystem.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task findById(Long id) {
        Optional<Task> obj = repository.findById(id);
        return obj.get();
    }

    public Task create(Task task) {
        return repository.save(task);
    }
}
