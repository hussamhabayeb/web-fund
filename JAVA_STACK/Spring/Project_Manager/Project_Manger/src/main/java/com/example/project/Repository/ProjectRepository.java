package com.example.project.Repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.example.project.models.Project;
import com.example.project.models.User;


public interface ProjectRepository extends CrudRepository<Project, Long> {
	 
	 List<Project> findAll();
	 List<Project> findAllByUsers(User user);
	 List<Project> findByUsersNotContains(User user);
	 
	 
	} 


