package com.example.demo.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
    private String key;

	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy="project", cascade = CascadeType.ALL)
	private List<Task> Tasks;
	
	public List<Task> getTasks() {
		return Tasks;
	}

	public void setTasks(List<Task> tasks) {
		Tasks = tasks;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
