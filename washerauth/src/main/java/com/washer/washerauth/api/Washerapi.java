package com.washer.washerauth.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.washer.washerauth.pojo.Washer;
import com.washer.washerauth.service.WasherService;

@RestController
@CrossOrigin("*")
public class Washerapi {
	
	@Autowired
	private WasherService washerService;
	
	@PostMapping("/login")
	public Object washerLogin(@RequestBody Washer washer)
	{
		return washerService.login(washer);
		
	}
	
	@PostMapping("/signup")
	public Object washerSignUp(@RequestBody Washer washer)
	{
		return washerService.signup(washer);
		
	}
	
	

}
