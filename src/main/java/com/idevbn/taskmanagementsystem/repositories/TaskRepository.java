package com.idevbn.taskmanagementsystem.repositories;

import com.idevbn.taskmanagementsystem.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
