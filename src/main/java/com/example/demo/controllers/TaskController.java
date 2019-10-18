package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Project;
import com.example.demo.entities.Task;
import com.example.demo.services.ProjectService;
import com.example.demo.services.TaskService;;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/tasks/create/{project_key}")
    public String PrepareCreate(Task task, Model model, @PathVariable String project_key) {
		model.addAttribute("project_key", project_key);
        return "tasks_create";
    }
	
	@PostMapping("/tasks/create/{project_key}")
	public String PostTask( @Valid Task task, @PathVariable String project_key, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "tasks_create";
		}
		//Save
		Project project = projectService.getByKey(project_key);
		task.setProject(project);
		taskService.save(task);
		return "redirect:/project/tasks/"+project_key;
	}
	
}
