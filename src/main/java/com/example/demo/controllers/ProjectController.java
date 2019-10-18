package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Project;
import com.example.demo.entities.Task;
import com.example.demo.services.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	
	@GetMapping("/projects/")
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("projects_list");
		List<Project> projects = new ArrayList<Project>();
		//Call services
		projects = projectService.getAll();
		mv.addObject("projects", projects);
		return mv;
	}
	
	@GetMapping("/projects/create")
    public String PrepareCreate(Project project) {
        return "projects_create";
    }
	
	@PostMapping("/projects/create")
	public String PostProject(@Valid Project project, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "projects_create";
		}
		//Do save
		projectService.save(project);
		return "redirect:/projects/";
	}
	
	@GetMapping("/project/tasks/{project_key}")
	public ModelAndView ProjectTasks(@PathVariable String project_key) {
		ModelAndView mv = new ModelAndView("tasks_list");
		Project project = projectService.getByKey(project_key);
		//TODO: Hardcoded
		mv.addObject("project_key",project_key);
		List<Task> tasks = new ArrayList<Task>();
		tasks = project.getTasks(); //Lazy Load ***
		
		mv.addObject("tasks", tasks);
		return mv;
	}
	
	
}
