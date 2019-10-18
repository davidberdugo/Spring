package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Task;

@Repository
public interface TaskRepository extends CrudRepository <Task, Integer> {

}
