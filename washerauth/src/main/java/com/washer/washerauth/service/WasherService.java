package com.washer.washerauth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washer.washerauth.pojo.Washer;
import com.washer.washerauth.repo.WasherRepo;

@Service
public class WasherService {
	
	@Autowired
	private WasherRepo washerRepo;
	
	
	public Object signup(Washer washer)
	{
		Optional<Washer> findExisted=washerRepo.findById(washer.getEmailId());
		if(findExisted.isPresent())
		{
			return "washer already existed";
		}
		else
		{
			return washerRepo.save(washer);
		}
		
		
		
	}
	
	public Object login(Washer washer)
	{
		Optional<Washer> findExisted=washerRepo.findById(washer.getEmailId());
		if(findExisted.isPresent())
		{
			Washer temp=findExisted.get();
			if(temp.getPassword().contentEquals(washer.getPassword()))
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
