package com.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.Address;
import com.cs.bean.Cart;
import com.cs.bean.EndUser;
import com.cs.bean.Login;
import com.cs.dto.Register;
import com.cs.repository.IEndUserRepository;

@Service
public class EndUserServiceImp implements IEndUserService{

	@Autowired
	IEndUserRepository endUserRepo;

	@Override
	public EndUser addCustomer(Register customer) 
	{
		EndUser c = new EndUser();
		c.setFullName(customer.getName());
		Cart cart = new Cart();
		Address address = new Address();
		address.setAddressId(customer.getAddressId());
		cart.setCartId(customer.getCartId());
		c.setCart(cart);
		c.setAddress(address);
		c.setLogin(customer.getLogin());
		return endUserRepo.save(c);
	}

	@Override
	public List<EndUser> getAllUser() 
	{
		return endUserRepo.findAll();
	}


}
