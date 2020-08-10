package com.example.customerauth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customerauth.pojo.Customer;
import com.example.customerauth.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	public Object signup(Customer customer)
	{
		Optional<Customer> findExisted=customerRepo.findById(customer.getEmailId());
		if(findExisted.isPresent())
		{
			return "customer already existed";
		}
		else
		{
			return customerRepo.save(customer);
		}
		
		
		
	}
	
	public Object login(Customer customer)
	{
		Optional<Customer> findExisted=customerRepo.findById(customer.getEmailId());
		if(findExisted.isPresent())
		{
			Customer temp=findExisted.get();
			if(temp.getPassword().contentEquals(customer.getPassword()))
			{
				return temp;
			}
			else
			{
			  return "password mismatch";
			}
		}
		return "can't find your account, please register to avail services";
	}

}
