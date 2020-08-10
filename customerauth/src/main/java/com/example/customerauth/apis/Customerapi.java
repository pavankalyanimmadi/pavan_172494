package com.example.customerauth.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerauth.pojo.Customer;
import com.example.customerauth.service.CustomerService;

@RestController
@CrossOrigin("*")
public class Customerapi {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/signup")
	public Object signup(@RequestBody Customer customer)
	{
		return customerService.signup(customer);
		
		
	}
	
	
	@PostMapping("/login")
	public Object login(@RequestBody Customer customer)
	{
		return customerService.login(customer);
	}

}
