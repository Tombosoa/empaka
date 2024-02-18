package com.javaadr.renderapi.Service;

import com.javaadr.renderapi.Entity.Project;
import com.javaadr.renderapi.Repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Optional<Project> getOne(int id){
        return projectRepository.findById(id);
    }
    public Project save(Project toSave){
        return projectRepository.save(toSave);
    }
}
