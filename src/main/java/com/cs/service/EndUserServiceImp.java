package com.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.EndUser;
import com.cs.repository.IEndUserRepository;

@Service
public class EndUserServiceImp implements IEndUserService{

	@Autowired
	IEndUserRepository endUserRepo;

	@Override
	public EndUser addCustomer(EndUser customer) 
	{
		return endUserRepo.save(customer);
	}

	@Override
	public List<EndUser> getAllUser() 
	{
		return endUserRepo.findAll();
	}


}
