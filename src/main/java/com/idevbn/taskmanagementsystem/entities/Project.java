package com.idevbn.taskmanagementsystem.entities;

import com.idevbn.taskmanagementsystem.entities.enums.TaskPriority;
import com.idevbn.taskmanagementsystem.entities.enums.TaskStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The title field should not be empty")
    private String title;

    @NotNull(message = "The task priority field should not be empty")
    private Integer taskPriority;

    @NotNull(message = "The task status field should not be empty")
    private Integer taskStatus;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTaskPriority(TaskPriority taskPriority) {
        if (taskPriority != null) {
            this.taskPriority = taskPriority.getCode();
        }
    }

    public TaskStatus getTaskStatus() {
        TaskStatus taskStatusValue = TaskStatus.valueOf(taskStatus);
        return taskStatusValue;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        if (taskStatus != null) {
            this.taskStatus = taskStatus.getCode();
        }
    }
}
