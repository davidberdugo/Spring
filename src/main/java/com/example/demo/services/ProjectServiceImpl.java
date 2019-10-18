package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Project;
import com.example.demo.repositories.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	ProjectRepository projectRepository;
		
	@Override
	public void save(Project project) {
		projectRepository.save(project);
	}
	
	@Override
	public List<Project> getAll() {
		List<Project> projects = (List<Project>) projectRepository.findAll();
		return projects;
	}
	
	@Override
	public Project getByKey(String projectKey) {
		return projectRepository.findById(projectKey).get();
	}

}
