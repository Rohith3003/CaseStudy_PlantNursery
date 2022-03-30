package com.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.EndUser;
import com.cs.bean.GardenDecor;
import com.cs.bean.Seed;
import com.cs.bean.Seed;
import com.cs.bean.Seed;
import com.cs.bean.Seed;
import com.cs.exception.SeedNotFoundException;
import com.cs.exception.SeedNotFoundException;
import com.cs.exception.SeedNotFoundException;
import com.cs.exception.SeedNotFoundException;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.ISeedRepository;
/**
 * Seed service implementation class used by SeedController
 * to interact with database.
 * @author Palak
 *
 */
@Service
public class SeedServiceImpl implements ISeedService {
	@Autowired
	ISeedRepository seedRepo;

	@Autowired
	IEndUserRepository endUserRepo;
	@Override
	public Seed addSeed(Seed seed, int userId) {
		//Add seed to the database
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new SeedNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
			//only Admin can add seed in the database
		{
			throw new SeedNotFoundException("only admin can add seed to the database");
		}
		else
		{
		return seedRepo.save(seed);
		}
	}

	@Override
	public Seed getSeedById(int id) {
		//Fetches a seed from the database by Seed Id.
		Optional<Seed> seed=seedRepo.findById(id);
		if(!seed.isPresent())
			throw new SeedNotFoundException("Seed not found with id: "+id);
		return seed.get();
	}
	@Override
	public List<Seed> getAllSeeds() {
		// Fetches all the seed records from DB
		return seedRepo.findAll();
	}

	public Seed updateSeedPhoto(int seedId,String photoLoc, int userId) {
		//Update photo location of the the seed photo.
		//Optional<Seed> seed = seedRepo.findById(seedId);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new SeedNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new SeedNotFoundException("only admin can add seed to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new SeedNotFoundException("first login to add seed to the database");
		}
//		else
//		{
//			seed.get().setPhotoLoc(photoLoc);
//			return seedRepo.save(seed.get());
//		}
		else
		{
			Optional<Seed> seed=seedRepo.findById(seedId);
			if(!seed.isPresent())
				throw new SeedNotFoundException("Seed not found with id: "+seedId);
			Seed updatedSeed=seed.get();
			updatedSeed.setPhotoLoc(photoLoc);
			return seedRepo.save(updatedSeed);
		}

	}

	@Override
	public Seed getSeedByName(String name) {

		Seed returned_seed=seedRepo.getByName(name);
		if(returned_seed==null)
			throw new SeedNotFoundException("Seed with name: "+name+" not found");
		return returned_seed;
		//return seedRepo.getByName(name);
	}

	@Override
	public Seed deleteSeedById(int id, int userId) {
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new SeedNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new SeedNotFoundException("only admin can add seed to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new SeedNotFoundException("first login to add seed to the database");
		}
		else
		{
		// Fetch the existing record from database
		Optional<Seed> seed=seedRepo.findById(id);
		if(!seed.isPresent())
			throw new SeedNotFoundException("Seed not found with id: "+id);
		//Use JPARepository method
		seedRepo.delete(seed.get());
		return seed.get();
		}

		
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
	public Seed updateSeedPrice(int id,double price, int userId) {
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if(!endUser.isPresent())
		{
			throw new SeedNotFoundException("admin not found with the given id:" + userId);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new SeedNotFoundException("only admin can add seed to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new SeedNotFoundException("first login to add seed to the database");
		}
		else
		{
			Optional<Seed> seed=seedRepo.findById(id);
			if(!seed.isPresent())
				throw new SeedNotFoundException("Seed not found with id: "+id);
			Seed updatedSeed=seed.get();
			updatedSeed.setPrice(price);
			return seedRepo.save(updatedSeed);
		}

	}

	
}
