package com.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cs.bean.OrderDetails;

@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails, Integer> {

	@Query(value="Select * from order_details where order_details.customer_id=:customerId", nativeQuery = true)
	List<OrderDetails> findOrderByCustomerId(@Param("customerId") int customerId);
}
