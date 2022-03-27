package com.cs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cs.bean.Planter;
import com.cs.repository.IPlanterRepository;

public interface IPlanterService {
	
	//Add new Planter
	public Planter addPlanter(Planter planter);
	
	//Update planter price
	public Planter updatePlanterPrice(int id,float price);
	
	//Update planter location
	public Planter updatePlanterPhoto(int id,String photoLoc);
	
	//Get Planter by Id
	public Planter getPlanterById(int id);
	
	//Get Planter by name
	public Planter getPlanterByName(String name);
	
	//Get all planters
	public List<Planter> getAllPlanters();
	
	//delete planter by Id
	public Planter deletePlanterById(int id);
}
