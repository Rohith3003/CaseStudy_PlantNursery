package com.cs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.bean.EndUser;
import com.cs.bean.GardenDecor;
import com.cs.exception.GardenDecorException;
import com.cs.repository.IGardenDecorRepository;
import com.cs.repository.IEndUserRepository;

@Service
public class GardenDecorServiceImpl implements IGardenDecorService
{
	@Autowired
	IGardenDecorRepository gardenDecorRepo;
	@Autowired
	IEndUserRepository endUserRepo;
	
	// add garden decor
	@Override
	public GardenDecor addGardenDecor(int id, GardenDecor gardenDecor) 
	{
		/*Optional<EndUser> endUser = endUserRepo.findById(id);
		if(!endUser.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new GardenDecorException("only admin can add garden decor to the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to add garden decor to the database");
		}
		else*/
		{
			return gardenDecorRepo.save(gardenDecor);
		}
	}
	
	// get garden decor based on id
	@Override
	public GardenDecor getGardenDecorById(int id) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(id);
		if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + id);
		}
		return gardenDecor.get();
	}

	// get all garden decor
	@Override
	public List<GardenDecor> getAllGardenDecor() 
	{
		return gardenDecorRepo.findAll();
	}

	// update garden decor name based on id
	@Override
	public GardenDecor updateGardenDecorNameById(int id, int gardenDecorId, String gardenDecorName) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(gardenDecorId);
		/*Optional<EndUser> endUser = endUserRepo.findById(id);
		if(!endUser.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new GardenDecorException("only admin can update garden decor in the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to update garden decor in the database");
		}
		else if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else*/
		{
			gardenDecor.get().setGardenDecorName(gardenDecorName);
			return gardenDecorRepo.save(gardenDecor.get());
		}
	}

	// update garden decor price basen on id
	@Override
	public GardenDecor updateGardenDecorPriceById(int id, int gardenDecorId, double gardenDecorPrice) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(gardenDecorId);
		/*Optional<EndUser> endUser = endUserRepo.findById(id);
		if(!endUser.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new GardenDecorException("only admin can update garden decor in the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to update garden decor in the database");
		}
		else if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else*/
		{
			gardenDecor.get().setGardenDecorPrice(gardenDecorPrice);
			return gardenDecorRepo.save(gardenDecor.get());
		}
	}

	// update garden decor description based on id
	@Override
	public GardenDecor updateGardenDecorDescriptionById(int id, int gardenDecorId, String gardenDecorDescription) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(gardenDecorId);
		/*Optional<EndUser> endUser = endUserRepo.findById(id);
		if(!endUser.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new GardenDecorException("only admin can update garden decor in the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to update garden decor in the database");
		}
		else if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else*/
		{
			gardenDecor.get().setGardenDecorDescription(gardenDecorDescription);
			return gardenDecorRepo.save(gardenDecor.get());
		}
	}

	// update garden decor image based on id
	@Override
	public GardenDecor updateGardenDecorImageById(int id, int gardenDecorId, String gardenDecorImage) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(gardenDecorId);
		/*Optional<EndUser> endUser = endUserRepo.findById(id);
		if(!endUser.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new GardenDecorException("only admin can update garden decor in the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to update garden decor in the database");
		}
		else if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else*/
		{
			gardenDecor.get().setGardenDecorImage(gardenDecorImage);
			return gardenDecorRepo.save(gardenDecor.get());
		}
	}
	
	// delete garden decor based on id
	@Override
	public GardenDecor deleteGardenDecorById(int id, int gardenDecorId) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(gardenDecorId);
		/*Optional<EndUser> endUser = endUserRepo.findById(id);		
		if(!endUser.isPresent())
		{
			throw new GardenDecorException("admin not found with the given id:" + id);
		}
		else if(!endUser.get().isAdmin())
		{
			throw new GardenDecorException("only admin can delete garden decor from the database");
		}
		else if(!endUser.get().getLogin().isLogin())
		{
			throw new GardenDecorException("first login to delete garden decor from the database");
		}
		else if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		else*/
		{
			gardenDecorRepo.deleteById(gardenDecorId);
			return gardenDecor.get();
		}
	}
}
