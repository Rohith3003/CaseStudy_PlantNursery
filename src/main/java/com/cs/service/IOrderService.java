package com.cs.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.cs.bean.OrderDetails;
import com.cs.bean.Payment;

public interface IOrderService {

	OrderDetails placeOrder(int customerId, Payment payment);
	List<OrderDetails> viewOrder(int customerId);
}
