package com.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cs.bean.Planter;
import com.cs.repository.IPlanterRepository;

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
	public Planter addPlanter(Planter planter);
	
	/**
	 * Update planter price  by id
	 * @param id
	 * @param price
	 * @return planter
	 */
	public Planter updatePlanterPrice(int id,float price);
	
	/**
	 * Update planter price by name
	 * @param name
	 * @param price
	 * @return planter
	 */
	public Planter updatePlanterPrice(String name,float price);
	
	/**
	 * Update planter location
	 * @param id
	 * @param photoLoc
	 * @return planter
	 */
	public Planter updatePlanterPhoto(int id,String photoLoc);
	
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
	public List<Planter> getAllPlanters();
	
	/**
	 * delete planter by Id
	 * @param id
	 * @return planter
	 */
	public Planter deletePlanterById(int id);
	
	/**
	 * delete planter by name
	 * @param name
	 * @return planter
	 */
	public Planter deletePlanterByName(String name);
}
