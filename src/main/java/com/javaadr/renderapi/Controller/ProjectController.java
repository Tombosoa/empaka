package com.javaadr.renderapi.Controller;

import com.javaadr.renderapi.Entity.Project;
import com.javaadr.renderapi.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/all")
    public List<Project> findAll(){
        return projectService.getProjects();
    }

    @GetMapping("/{id}")
    public Optional<Project> findById(@PathVariable int id){
        return projectService.getOne(id);
    }

    @PostMapping("/newProject")
    public Project save(@RequestBody Project project){
        return projectService.save(project);
    }
}
