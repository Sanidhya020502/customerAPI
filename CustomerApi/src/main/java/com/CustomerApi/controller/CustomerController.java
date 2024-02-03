package com.CustomerApi.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CustomerApi.model.Customer;
import com.CustomerApi.service.CustomerService;


@Controller
public class CustomerController {

	CustomerService customerService;
	
	public CustomerController(CustomerService customerService) { //constructor injection
		this.customerService = customerService;
	}
	
	
	
	@GetMapping("/update/{id}")
	public ModelAndView getCustomerDetails(@PathVariable("id") String id,Model model) {
			Customer customer =  customerService.getCustomer(id);
			model.addAttribute("customer",customer);
			ModelAndView modelAndView = new ModelAndView();
		    modelAndView.setViewName("updateCustomers");
		    return modelAndView;
		
	}
	
	@GetMapping("/customers")
	public ModelAndView getAllCustomerDetails(Model model){
		List<Customer> customerList = customerService.getAllCustomer();
		model.addAttribute("customerList", customerList);
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("index");
	    return modelAndView;
	}
	
	@GetMapping("/add/page")
    public ModelAndView addPage(Model model){
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("customer",new Customer());
	    modelAndView.setViewName("addCustomers");
	    return modelAndView;
    }
	
	
	@PostMapping("/save")
	public String createCustomerDetails(@ModelAttribute Customer customer) {
		customerService.createCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/update/page")
    public ModelAndView updatePage(@ModelAttribute Customer customer ,Model model){
		ModelAndView modelAndView = new ModelAndView();
		model.addAttribute("customer",customer);
	    modelAndView.setViewName("updateCustomers");
	    return modelAndView;
	}
	
	
	@PostMapping("/update/page")
	public String updatedDetails(@ModelAttribute Customer updatedCustomer ) {
		 Customer existingCustomer = customerService.getCustomer(updatedCustomer.getId());

		    // Update the existing customer properties with values from the updatedCustomer
		 existingCustomer.setId(updatedCustomer.getId());
		    existingCustomer.setFirst_name(updatedCustomer.getFirst_name());
		    existingCustomer.setLast_name(updatedCustomer.getLast_name());
		    existingCustomer.setStreet(updatedCustomer.getStreet());
		    existingCustomer.setAddress(updatedCustomer.getAddress());
		    existingCustomer.setCity(updatedCustomer.getCity());
		    existingCustomer.setState(updatedCustomer.getState());
		    existingCustomer.setEmail(updatedCustomer.getEmail());
		    existingCustomer.setPhone(updatedCustomer.getPhone());

		    // Save the updated customer
		    customerService.updateCustomer(existingCustomer);

		    // Redirect to the customers page
		    return "redirect:/customers";
	}

//	@DeleteMapping("/delete/{id}")
	@GetMapping("/delete/{id}")
	public String deleteCustomerDetails(@ModelAttribute Customer customer) {
		customerService.deleteCustomer(customer.getId());
		return "redirect:/customers";
	}
}

