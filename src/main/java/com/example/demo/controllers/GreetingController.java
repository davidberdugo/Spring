package com.example.demo.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Project;
import com.example.demo.entities.Task;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(Model model) {
    	
        return "greeting";
    }

}