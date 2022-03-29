package com.cs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cs.bean.Planter;

/**
 * Repository interface extending JPARepository for Planter entity, 
 * that interacts with database. 
 * @author Hemanth
 *
 */
public interface IPlanterRepository extends JpaRepository<Planter, Integer> {
	
	/**
	 * Get Planter by name
	 * @param name
	 * @return planter
	 */
	@Query(value="select p from Planter p where p.name=:name")
	public Planter getByName(@Param("name") String name);
	
	/**
	 * Delete Planter by name
	 * @param name
	 * @return planter
	 */
	@Query(value = "delete from planter where name=:name returning *", nativeQuery = true)
	public Planter deleteByName(@Param("name") String name);
	
	/**
	 * Get planters bought by customer
	 * @param customerId
	 * @return planter
	 */
	//@Query(value="select p from planter p join cart_planter cp on p.planter_id=cp.planter_id join end_user eu on eu.cart_id=cp.cart_id where eu.customer_id=:customerId")
	@Query(value="select * from planter join cart_planter on planter.planter_id=cart_planter.planter_id join end_user on end_user.cart_id=cart_planter.cart_id where end_user.customer_id=:customerId",nativeQuery = true)
	public List<Planter> getPlantersByCustomerId(@Param("customerId") int customerId);
}
