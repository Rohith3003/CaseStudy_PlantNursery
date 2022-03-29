package com.cs.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;

import com.cs.bean.Planter;
import com.cs.dto.PlanterDto;

/**
 * Interface containing the methods to be implemented in Planter service implementation 
 * that interacts with controller and database.
 * @author Hemanth
 *
 */
public interface IPlanterService {
	
	/**
	 * Add new Planter
	 * @param planter
	 * @return planter
	 */
	public Planter addPlanter(Planter planter, int userId);
	
	/**
	 * Update planter price  by id
	 * @param id
	 * @param price
	 * @return planter
	 */
	public Planter updatePlanterPrice(int id,float price, int userId);
	
	/**
	 * Update planter price by name
	 * @param name
	 * @param price
	 * @return planter
	 */
	public Planter updatePlanterPrice(String name,float price, int userId);
	
	/**
	 * Update planter location
	 * @param id
	 * @param photoLoc
	 * @return planter
	 */
	public Planter updatePlanterPhoto(int id,String photoLoc, int userId);
	
	/**
	 * Get Planter by Id
	 * @param id
	 * @return planter
	 */
	public Planter getPlanterById(int id);
	
	/**
	 * Get Planter by name
	 * @param name
	 * @return planter
	 */
	public Planter getPlanterByName(String name);
	
	/**
	 * Get all planters
	 * @return planter
	 */
	public List<PlanterDto> getAllPlanters();
	
	/**
	 * delete planter by Id
	 * @param id
	 * @return planter
	 */
	public Planter deletePlanterById(int id, int userId);
	
	/**
	 * delete planter by name
	 * @param name
	 * @return planter
	 */
	public Planter deletePlanterByName(String name, int userId);
	
	/**
	 * Returns list of planters bought by particular customer
	 * @param customerId
	 * @return List(Planters)
	 */
	public List<PlanterDto> getPlantersByCustomerId(int customerId);
	
	/**
	 * Returns the list of all Planters sorted on specific field
	 * @param field
	 * @return List(Planters)
	 */
	public List<PlanterDto> getAllPlantersInSortingOrder(String field);
	
	/**
	 * Returns the list of all Planters in paginated format
	 * @param offset
	 * @param pageSize
	 * @return Page(Planters)
	 */
	public Page<Planter> getAllPlantersWithPagination(int offset,int pageSize);
}
