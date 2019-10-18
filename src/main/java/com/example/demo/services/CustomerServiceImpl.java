package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import com.example.demo.entities.Customer;
import com.example.demo.repositories.CustomerRepository;;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAll() {
		List<Customer> customers = (List<Customer>) customerRepository.findAll();
		return customers;
	}
	
	@Override
	public List<Customer> findByName(String name) {
		List<Customer> customers = (List<Customer>) customerRepository.findByName(name);
		return customers;
	}

	@Override
	public Customer getByKey(String customerKey) {
		return customerRepository.findById(customerKey).get();
	}

	@Override
	public long deleteByKey(String key) {
		return customerRepository.deleteByKey(key);
	}

	
	
}
