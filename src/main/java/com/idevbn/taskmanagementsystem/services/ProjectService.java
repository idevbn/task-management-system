package com.idevbn.taskmanagementsystem.services;

import com.idevbn.taskmanagementsystem.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;
}
