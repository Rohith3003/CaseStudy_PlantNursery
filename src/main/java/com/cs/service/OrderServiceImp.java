package com.cs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.Cart;
import com.cs.bean.EndUser;
import com.cs.bean.Fertilizer;
import com.cs.bean.GardenDecor;
import com.cs.bean.OrderDetails;
import com.cs.bean.Payment;
import com.cs.bean.Plant;
import com.cs.bean.Planter;
import com.cs.bean.Seed;
import com.cs.exception.OrderException;
import com.cs.exception.UserNotFoundException;
import com.cs.repository.ICartRepository;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.IOrderRepository;

@Service
public class OrderServiceImp implements IOrderService {

	@Autowired
	IOrderRepository orderRepo;

	@Autowired
	IEndUserRepository endUserRepo;
	
	@Autowired
	ICartRepository cartRepo;

	@Override
	public OrderDetails placeOrder(int customerId, Payment payment) {
		Optional<EndUser> endUser = endUserRepo.findById(customerId);
		if(endUser.isEmpty())
		{
			throw new UserNotFoundException("Customer with the given id: "+customerId+" not found.");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new OrderException("Customer should login before placing a order");
		}
		else
		{
			Cart cart = endUser.get().getCart();
			List<GardenDecor> gardenDecorList = cart.getGardenDecor();
			List<Seed> seedList = cart.getSeed();
			List<Plant> plantList = cart.getPlant();
			List<Planter> planterList = cart.getPlanter();
			List<Fertilizer> fertilizerList = cart.getFertilizer();
			OrderDetails order = new OrderDetails();
			order.setBillAmount(cart.getCartCost());
			order.setPaymentType(payment);
			order.setCustomerName(endUser.get().getFullName());
			order.setCustomerId(customerId);
			orderRepo.findOrderByCustomerId(customerId);
			endUser.get().setOrder(order);
			seedList.removeAll(seedList);
			fertilizerList.removeAll(fertilizerList);
			plantList.removeAll(plantList);
			planterList.removeAll(planterList);
			gardenDecorList.removeAll(gardenDecorList);
			cart.setFertilizer(fertilizerList);
			cart.setGardenDecor(gardenDecorList);
			cart.setPlant(plantList);
			cart.setPlanter(planterList);
			cart.setSeed(seedList);
			cart.setCartCost(0.0);
			endUser.get().setCart(cart);
			endUserRepo.save(endUser.get());
			int id = order.getOrderId();
			System.out.println(id);
			return order;
		}
	}

	@Override
	public List<OrderDetails> viewOrder(int customerId) {
		Optional<EndUser> endUser = endUserRepo.findById(customerId);
		if(endUser.isEmpty())
		{
			throw new UserNotFoundException("Customer with the given id: "+customerId+" not found.");
		}
		else
		{
			return orderRepo.findOrderByCustomerId(customerId);
		}
	}

}
