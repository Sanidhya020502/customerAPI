package com.CustomerApi.serviceimpl;



import java.util.ArrayList;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CustomerApi.model.Customer;
import com.CustomerApi.repository.CustomerRepo;
import com.CustomerApi.service.CustomerService;

import jakarta.transaction.Transactional;

@Service 
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepo customerRepo;

	public CustomerServiceImpl(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	@Override 
	public String createCustomer(Customer customer) {
		customerRepo.save(customer);
		return "customer created";
	}

	@Override
	public String updateCustomer(Customer customer) {
		customerRepo.save(customer);
		return "customer updated";
	}

	@Override
	public String deleteCustomer(String id) {
		customerRepo.deleteById(id);
		return "customer deleted";
	}

	@Override
	public Customer getCustomer(String id) {
		return customerRepo.findById(id).get();
		
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list = new ArrayList<>();
		customerRepo.findAll().forEach(list::add);
		return list;
	}
	
	
	
}
