package com.cs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.bean.EndUser;
import com.cs.dto.Register;
import com.cs.service.IEndUserService;



@RestController
public class EndUserController 
{
	@Autowired
	IEndUserService endUserServ;

	@PostMapping("/addCustomer")
	ResponseEntity<EndUser> addCustomer(@RequestBody Register customer) 
	{
		EndUser endUser = endUserServ.addCustomer(customer);
		return new ResponseEntity<>(endUser, HttpStatus.OK);
	};
	
	@GetMapping("/getAllCustomer")
	ResponseEntity<List<EndUser>> getAllCustomer() 
	{
		List<EndUser> endUser = endUserServ.getAllUser();
		return new ResponseEntity<>(endUser, HttpStatus.OK);
	};
}
