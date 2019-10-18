package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String>  {
	public List<Customer> findByName(String name);
	public long deleteByKey(String name);
}
