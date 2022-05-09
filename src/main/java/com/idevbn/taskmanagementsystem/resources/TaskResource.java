package com.idevbn.taskmanagementsystem.resources;

import com.idevbn.taskmanagementsystem.entities.Task;
import com.idevbn.taskmanagementsystem.entities.enums.TaskStatus;
import com.idevbn.taskmanagementsystem.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @Autowired
    private TaskService taskService;

    @GetMapping(value = "/status/{taskId}")
    public ResponseEntity<TaskStatus> findTaskStatus(@PathVariable Long taskId) {
        Task obj = taskService.findTaskStatus(taskId);

        return ResponseEntity.status(HttpStatus.OK).body(obj.getTaskStatus());
    }

    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody Task task) {
        Task obj = taskService.create(task);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
}
