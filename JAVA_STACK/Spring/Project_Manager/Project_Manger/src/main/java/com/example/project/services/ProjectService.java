package com.example.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.Repository.ProjectRepository;
import com.example.project.models.Project;
import com.example.project.models.User;


@Service
public class ProjectService  {

	
	@Autowired
    private ProjectRepository projectRepo;
	
	
	 // returns all the Project
    public List<Project> allProjects() {
        return projectRepo.findAll();
    }
    // creates a Project
    public Project createProject(Project b) {
        return projectRepo.save(b);
    }
    // retrieves a Project
    public Project findProject(Long id) {
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()) {
            return optionalProject.get();
        } else {
            return null;
        }
    }
    
    public List<Project> getAssignedProjects(User user){
		return projectRepo.findAllByUsers(user);
	}
    public Project updateProject(Project project) {
		return projectRepo.save(project);
	}
    
    public Project addProject(Project project) {
		return projectRepo.save(project);
	}
    public List<Project> getUnassignedProjects(User user){
		return projectRepo.findByUsersNotContains(user);
	}
	
    public void deleteProject(Project project) {
		projectRepo.delete(project);
	}
}
