package com.useraccount.springboot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.useraccount.springboot.exception.ResourceNotFoundException;
import com.useraccount.springboot.model.Customer;
import com.useraccount.springboot.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	//get all customers
	public List<Customer> getAllCustomers(){
		return customerRepository.findAll();
	}
	
	//create employee
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	//get employee by Id
	public ResponseEntity<Customer> getCustomerByIdCustomer(Long id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with Id :"+id));
		return ResponseEntity.ok(customer);
	}
	
	//update customer
	public ResponseEntity<Customer> updateCustomerLong(Long id, Customer customerDetails){
		
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not exist with Id :"+id));
		
		customer.setFirstName(customerDetails.getFirstName());
		customer.setLastName(customerDetails.getLastName());
		customer.setEmailId(customerDetails.getEmailId());
		customer.setGender(customerDetails.getGender());
		customer.setDateOfBirth(customerDetails.getDateOfBirth());
		customer.setPhone(customerDetails.getPhone());
		customer.setPassword(customerDetails.getPassword());
		
		Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);			
	}
	
	//delete customer
	public ResponseEntity<Map<String, Boolean>> deleteCustomer(Long id){
		
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with Id :"+id));
		
		customerRepository.delete(customer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
}
