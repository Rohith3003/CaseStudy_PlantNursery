package com.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.Seed;
import com.cs.exception.SeedNotFoundException;
import com.cs.repository.ISeedRepository;

@Service
public class SeedServiceImpl implements ISeedService {
	@Autowired
	ISeedRepository seedRepo;

	
	@Override
	public Seed addSeed(Seed seed) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add seed to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add seed to the database");
//		}
//		else
//		{
//		return seedRepo.save(seed);
//		}
		return seedRepo.save(seed);
		
	}

	@Override
	public Seed getSeedById(int id) {
		Optional<Seed> seed=seedRepo.findById(id);
		if(seed.isEmpty())
			throw new SeedNotFoundException("Seed not found with id: "+id);
		return seed.get();
	}
	@Override
	public List<Seed> getAllSeeds() {
		// Fetches all the seed records from DB
		return seedRepo.findAll();
	}

	public Seed updateSeedPhoto(int seedId,String photoLoc) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new SeedNotFoundException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new SeedNotFoundException("only admin can add seed to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new SeedNotFoundException("first login to add seed to the database");
//		}
//		else
//		{
			Optional<Seed> seed=seedRepo.findById(seedId);
			if(!seed.isPresent())
				throw new SeedNotFoundException("Seed not found with id: "+seedId);
			Seed updatedSeed=seed.get();
			updatedSeed.setPhotoLoc(photoLoc);
			return seedRepo.save(updatedSeed);
//		}
	}

	@Override
	public Seed getSeedByName(String name) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add seed to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add seed to the database");
//		}
//		else
//		{
//return seedRepo.getByName(name);
//		}
		return seedRepo.getByName(name);
	}

	//@Override
	/*public Seed deleteSeedById(int id) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add seed to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add seed to the database");
//		}
//		else
//		{
		// Fetch the existing record from database
		Optional<Seed> seed=seedRepo.findById(id);
		if(!seed.isPresent())
			throw new SeedNotFoundException("Seed not found with id: "+id);
		//Use JPARepository method
		seedRepo.delete(seed.get());
		return seed.get();
//		}
		// Fetch the existing record from database
		//Seed seed=seedRepo.getById(id);
		//Use JPARepository method
		//seedRepo.delete(seed);
		//return seed;
	}*/
//	@Override
//	public void deleteSeed(int id) {
//		// TODO Auto-generated method stub
//		Optional<Seed> opt = seedRepo.findById(id);
//		if(!opt.isPresent()) {
//			throw new SeedNotFoundException("Seed not found with given id "+ id);
//		}
//		seedRepo.deleteById(id);
//		
//	}
	@Override
	public Seed deleteSeedById(int id) {
		// Check given Seed is there in db or not
		Optional<Seed> opt = seedRepo.findById(id);
		if(!opt.isPresent()) {
			throw new SeedNotFoundException("Seed not found with given id "+ id);
		}
		// delete seed
		seedRepo.deleteById(id);
		return opt.get();
		
	}
	@Override
	public void deleteSeed(int id) {
		// TODO Auto-generated method stub
		Optional<Seed> opt = seedRepo.findById(id);
		if(!opt.isPresent()) {
			throw new SeedNotFoundException("Seed not found with given id "+ id);
		}
		seedRepo.deleteById(id);
		
	}
	@Override
	public Seed updateSeedPrice(int id,double price) {
//		Optional<EndUser> endUser = endUserRepo.findById(id);
//		if(!endUser.isPresent())
//		{
//			throw new GardenDecorException("admin not found with the given id:" + id);
//		}
//		else if(!endUser.get().getRole().equals("admin"))
//		{
//			throw new GardenDecorException("only admin can add seed to the database");
//		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new GardenDecorException("first login to add seed to the database");
//		}
//		else
//		{
			Optional<Seed> seed=seedRepo.findById(id);
			if(!seed.isPresent())
				throw new SeedNotFoundException("Seed not found with id: "+id);
			Seed updatedSeed=seed.get();
			updatedSeed.setPrice(price);
			return seedRepo.save(updatedSeed);
//		}
		//Seed seed=seedRepo.getById(id);
		//seed.setPrice(price);
		//return seedRepo.save(seed);
	}

	
}
