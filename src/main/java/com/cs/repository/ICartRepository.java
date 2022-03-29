package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cs.bean.Cart;
/**
 * This interface acts as repository which communicates with database and
 * executes all the queries coming from CartService to database
 * @author  Mayank Kumar(Employee ID: 46191925)
 *
 */
@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer>{

}
