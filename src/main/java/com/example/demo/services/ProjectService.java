package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Project;

public interface ProjectService {
	
	void save(Project project);
	
	List<Project> getAll();
	
	Project getByKey (String projectKey);
}