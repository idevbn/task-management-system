package com.idevbn.taskmanagementsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.idevbn.taskmanagementsystem.entities.enums.TaskFrequency;
import com.idevbn.taskmanagementsystem.entities.enums.TaskPriority;
import com.idevbn.taskmanagementsystem.entities.enums.TaskStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer taskFrequency;

    private Integer taskPriority;

    private Integer taskStatus;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

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
