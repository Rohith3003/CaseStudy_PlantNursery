package com.cs.service;

import com.cs.bean.Plant;

public interface IPlantService {
			//Add new Plant
			public Plant addPlant(Plant plant);
			
			//Update Plant information
			public Plant updatePlantPrice(int id,double price);
			
			//Get Plant by Id
			public Plant getPlantById(int id);
			
			//Get Plant by name
			public Plant getPlantByName(String name);
			
			//delete Plant by Id
			public Plant deletePlantById(int id);
}
