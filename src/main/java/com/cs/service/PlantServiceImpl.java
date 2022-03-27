package com.cs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.EndUser;
import com.cs.bean.Plant;
import com.cs.exception.PlantNotFoundException;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.IPlantRepository;

@Service
public class PlantServiceImpl implements IPlantService {

	@Autowired
	IPlantRepository plantRepo;
	@Autowired
	IEndUserRepository endUserRepo;

	@Override
	public Plant addPlant(Plant plant) 
	{
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new PlantNotFoundException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new PlantNotFoundException("only admin can add plant to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new PlantNotFoundException("first login to add plant to the database");
//		}
		return plantRepo.save(plant);
	}

	@Override
	public Plant updatePlantPrice(int plantId, double price) 
	{
//		Optional<EndUser> endUser = endUserRepo.findById(id);
		Optional<Plant> plant = plantRepo.findById(plantId);
//		if(!endUser.isPresent())
//		{
//			throw new PlantNotFoundException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new PlantNotFoundException("only admin can update plant to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new PlantNotFoundException("first login to update plant to the database");
//		}
//		else if(!plant.isPresent())
//		{
//			throw new PlantNotFoundException("plant not found with the given id:" + plantId);
//		}
		plant.get().setPrice(price);
		return plantRepo.save(plant.get());
	}

	@Override
	public Plant getPlantById(int id) {
		Optional<Plant> plant=plantRepo.findById(id);
		if(!plant.isPresent())
			throw new PlantNotFoundException("Plant not found with id: "+id);
		return plantRepo.getById(id);
	}

	@Override
	public Plant getPlantByName(String name) {
		// TODO Auto-generated method stub
		return plantRepo.getByName(name);
	}

	@Override
	public Plant deletePlantById(int plantId) 
	{
		//Optional<EndUser> endUser = endUserRepo.findById(id);
		Optional<Plant> plant = plantRepo.findById(plantId);
//		if(!endUser.isPresent())
//		{
//			throw new PlantNotFoundException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new PlantNotFoundException("only admin can delete plant from the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new PlantNotFoundException("first login to delete plant from the database");
//		}
//		else if(!plant.isPresent())
//		{
//			throw new PlantNotFoundException("plant not found with the given id:" + plantId);
//		}
		plantRepo.deleteById(plantId);
		return plant.get();
	}

}
