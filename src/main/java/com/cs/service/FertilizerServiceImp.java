package com.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.EndUser;
import com.cs.bean.Fertilizer;
import com.cs.exception.FertilizerNotFoundException;
import com.cs.exception.UserNotFoundException;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.IFertilizerRepository;

/**
 * This class is used to provide services to FertilizerController so that we can
 * add, delete, update and retrieve the fertilizer into or from database
 * 
 * @author Rohith(Employee id: 46191986)
 *
 */
@Service
public class FertilizerServiceImp implements IFertilizerService {

	@Autowired
	IFertilizerRepository fertilizerRepo;
	@Autowired
	IEndUserRepository endUserRepo;

	// adds new fertilizer into database
	@Override
	public Fertilizer addFertilizer(int userId, Fertilizer fertilizer) {

		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		}
//		else if(!endUser.get().getLogin().isLogin())
//		{
//			throw new UserNotFoundException("first login to add garden decor to the database");
//		}
		else {
			return fertilizerRepo.save(fertilizer);
		}
	}

	// retrieves and returns the fertilizer from database based on given id.
	@Override
	public Fertilizer getFertilizerById(int id) {

		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(id);
		if (fertilizer.isEmpty()) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + id + " is not found");
		}
		return fertilizer.get();
	}

	// retrieves and returns the fertilizer of given name.
	@Override
	public Fertilizer getFertilizerByName(String name) {

		Fertilizer fertilizer = fertilizerRepo.findByFertilizerName(name);
		if (fertilizer == null) {
			throw new FertilizerNotFoundException("Fertilizer with the given name: " + name + " does not exist");
		}
		return fertilizer;
	}

	// retrieves the list of all available fertilizers
	@Override
	public List<Fertilizer> getAllFertilizers() {

		return fertilizerRepo.findAll();
	}

	/// updates the price of existing fertilizer of given id
	@Override
	public Fertilizer updatePriceById(int userId, int fertilizerId, double price) {

		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(fertilizerId);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (!(fertilizer.isPresent())) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + fertilizerId + " is not found");
		} else {
			fertilizer.get().setFertilizerPrice(price);
		}
		return fertilizerRepo.save(fertilizer.get());
	}

	// updates the price of existing fertilizer of given name
	@Override
	public Fertilizer updatePriceByName(int userId, String name, double price) {

		Fertilizer fertilizer = fertilizerRepo.findByFertilizerName(name);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (fertilizer == null) {
			throw new FertilizerNotFoundException("Fertilizer with the given name: " + name + " does not exist");
		}
		fertilizer.setFertilizerPrice(price);
		return fertilizerRepo.save(fertilizer);
	}

	// updates price and quantity of fertilizer of given id
	@Override
	public Fertilizer updatePriceAndQuantityById(int userId, int fertilizerId, double price, String quantity) {
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(userId);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (fertilizer.isEmpty()) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + fertilizerId + " is not found");
		}
		fertilizer.get().setFertilizerPrice(price);
		fertilizer.get().setFertilizerQuantity(quantity);
		return fertilizerRepo.save(fertilizer.get());
	}

	// deletes fertilizer from database based on id.
	@Override
	public Fertilizer removeFertilizerById(int userId, int fertilizerId) {
		Optional<Fertilizer> opt = fertilizerRepo.findById(fertilizerId);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (opt.isEmpty()) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + fertilizerId + " is not found");
		}
		fertilizerRepo.deleteById(fertilizerId);
		return opt.get();
	}

	// removes the fertilizer of given name from database
	@Override
	public Fertilizer removeFertilizerByName(int userId, String name) {

		Fertilizer fertilizer = fertilizerRepo.findByFertilizerName(name);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (fertilizer == null) {
			throw new FertilizerNotFoundException("Fertilizer with the given name: " + name + " does not exist");
		}
		return fertilizerRepo.deleteByName(name);
	}

}
