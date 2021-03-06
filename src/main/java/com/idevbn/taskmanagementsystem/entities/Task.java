package com.idevbn.taskmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.idevbn.taskmanagementsystem.entities.enums.TaskFrequency;
import com.idevbn.taskmanagementsystem.entities.enums.TaskPriority;
import com.idevbn.taskmanagementsystem.entities.enums.TaskStatus;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "The title field should not be empty")
    private String title;

    @NotNull(message = "The task frequency field should not be empty")
    private Integer taskFrequency;

    @NotNull(message = "The task priority field should not be empty")
    private Integer taskPriority;

    @NotNull(message = "The task status field should not be empty")
    private Integer taskStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @JsonBackReference
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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

    public TaskFrequency getTaskFrequency() {
        TaskFrequency taskFrequencyValue = TaskFrequency.valueOf(taskFrequency);
        return taskFrequencyValue;
    }

    public void setTaskFrequency(TaskFrequency taskFrequency) {
        if (taskFrequency != null) {
            this.taskFrequency = taskFrequency.getCode();
        }
    }

    public TaskPriority getTaskPriority() {
        TaskPriority taskPriorityValue = TaskPriority.valueOf(taskPriority);
        return taskPriorityValue;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
