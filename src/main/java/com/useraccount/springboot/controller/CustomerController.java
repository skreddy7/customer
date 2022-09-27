package com.useraccount.springboot.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.useraccount.springboot.model.Customer;
import com.useraccount.springboot.service.CustomerService;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private  CustomerService customerService;
	
	//get all customers
	@GetMapping("/customer")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	//create employee
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		return customerService.createCustomer(customer);
	}
	
	//get employee by Id
	@GetMapping("/customer/{id}")
	public ResponseEntity<Customer> getCustomerByIdCustomer(@PathVariable Long id) {
			return customerService.getCustomerByIdCustomer(id);
	}
	
	//update customer
	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomerLong(@PathVariable Long id, @RequestBody Customer customerDetails){
		return customerService.updateCustomerLong(id, customerDetails);			
	}
	
	//delete customer
	@DeleteMapping("/customer/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(@PathVariable Long id){
		
		return customerService.deleteCustomer(id);
		
	}
	
	
}
