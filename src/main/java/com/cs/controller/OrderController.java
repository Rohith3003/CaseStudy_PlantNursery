package com.cs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.bean.OrderDetails;
import com.cs.bean.Payment;
import com.cs.service.IOrderService;

@RestController
public class OrderController {
	
	@Autowired
	IOrderService orderServ;
	
	@PutMapping("/placeOrder/{customerId}")
	ResponseEntity<OrderDetails> placeOrder(@Valid @PathVariable("customerId") int customerId, @RequestBody Payment payment)
	{
		return new ResponseEntity<OrderDetails>(orderServ.placeOrder(customerId, payment),HttpStatus.OK);
	}
	
	@GetMapping("/getAllOrders/{customerId}")
	ResponseEntity<List<OrderDetails>> placeOrder(@Valid @PathVariable("customerId") int customerId)
	{
		return new ResponseEntity<>(orderServ.viewOrder(customerId),HttpStatus.OK);
	}

}
