package com.example.demo.services;

import java.util.List;

import com.example.demo.entities.Customer;

public interface CustomerService {
	
	void save(Customer customer);
	
	List<Customer> getAll();
	
	List<Customer> findByName(String name);
	
	Customer getByKey(String customerKey);
	
	long deleteByKey(String key);
	

}
