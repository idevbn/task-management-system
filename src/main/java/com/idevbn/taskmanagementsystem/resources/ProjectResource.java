package com.idevbn.taskmanagementsystem.resources;

import com.idevbn.taskmanagementsystem.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectResource {

    @Autowired
    private ProjectService projectService;
}
