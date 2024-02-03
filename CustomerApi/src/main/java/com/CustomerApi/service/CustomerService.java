package com.CustomerApi.service;

import java.util.List;
import com.CustomerApi.model.Customer;


public interface CustomerService {
	public String createCustomer(Customer customer);
	public String updateCustomer(Customer customer);
	public String deleteCustomer(String id);
	public Customer getCustomer(String id);
	public List<Customer> getAllCustomer();
	
}
