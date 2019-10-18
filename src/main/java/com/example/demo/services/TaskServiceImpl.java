package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Task;
import com.example.demo.repositories.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public void save(Task task) {
		taskRepository.save(task);
	}

}
