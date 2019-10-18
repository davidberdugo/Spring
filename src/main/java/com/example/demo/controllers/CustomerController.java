package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.http.MediaType; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Customer;
import com.example.demo.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/customers/")
	@ResponseBody
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("customers_list");
		List<Customer> customers = new ArrayList<Customer>();
		//Call services 
		customers = customerService.getAll();//***
		mv.addObject("customers", customers); //***Databind to served view
		return mv; 
		
	}
	
	@GetMapping("/customersdata/")
	@ResponseBody
	public ResponseEntity<?> CustomersData(@RequestParam("name") String name) {
		List<Customer> customers = new ArrayList<Customer>();
		//Call services 
		
		if(name != null && !name.trim().isEmpty()){
			customers = customerService.findByName(name);
		}
		else {
			customers = customerService.getAll();//***
		}
		
		ResponseEntity<List<Customer>> viewModel = new ResponseEntity<>(customers,HttpStatus.OK);

		return viewModel;
		
	}
	
	
	@GetMapping("/customers/create")
    public String PrepareCreate(Customer customers) {
        return "customers_create";
    }
	
	@PostMapping(value ="/customers/createForm")
	public String PostCustomer(@Valid Customer customer, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "customers_create";
		}
		//Do save
		customerService.save(customer);//***
		return "redirect:/customers/";
	}
	
	@PostMapping(value ="/customers/create", consumes= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> PostCustomerCreate(@Valid @RequestBody Customer customer) {
		
		
		if(customer.getKey() == null || customer.getKey().isEmpty()){
			return new ResponseEntity<String>("Erro key is null or empty ", HttpStatus.BAD_REQUEST);
		}
		
		
		customerService.save(customer);//***
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping(value="/customers/delete")
	@Transactional
	public ResponseEntity<?> DeleteCustomer(@RequestParam("key") String key){
		
		if(key != null && !key.trim().isEmpty()){
			
			customerService.deleteByKey(key);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
			
		}
		return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		
	}

	

}
