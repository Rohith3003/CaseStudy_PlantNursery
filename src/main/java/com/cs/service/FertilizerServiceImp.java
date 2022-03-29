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

	/**
	 * Adds new fertilizer to the database.
	 * 
	 * @param userId
	 * @param fertilizer
	 * @return Returns the fertilizer object which is persisted in database.
	 */
	@Override
	public Fertilizer addFertilizer(int userId, Fertilizer fertilizer) {

		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("User not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add fertilizer to the database");
		} else if (!endUser.get().getLogin().isLogin()) {
			throw new UserNotFoundException("first login to add fertilizer to the database");
		} else {
			return fertilizerRepo.save(fertilizer);
		}
	}

	/**
	 * Retrieves the fertilizer of given id from database.
	 * 
	 * @param id
	 * @return Returns the fertilizer of given id.
	 */
	@Override
	public Fertilizer getFertilizerById(int id) {

		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(id);
		if (fertilizer.isEmpty()) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + id + " is not found");
		}
		return fertilizer.get();
	}

	/**
	 * Retrieves the fertilizer of given name from database.
	 * 
	 * @param name
	 * @return Returns the fertilizer of given name.
	 */
	@Override
	public Fertilizer getFertilizerByName(String name) {

		Fertilizer fertilizer = fertilizerRepo.findByFertilizerName(name);
		if (fertilizer == null) {
			throw new FertilizerNotFoundException("Fertilizer with the given name: " + name + " does not exist");
		}
		return fertilizer;
	}

	/**
	 * Retrieves the list of all available fertilizers from database.
	 * 
	 * @return Returns the list of fertilizers.
	 */
	@Override
	public List<Fertilizer> getAllFertilizers() {

		return fertilizerRepo.findAll();
	}

	/**
	 * Updates the price of existing fertilizer of given id.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @param price
	 * @return Returns the updated fertilizer object from database.
	 */
	@Override
	public Fertilizer updatePriceById(int userId, int fertilizerId, double price) {

		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(fertilizerId);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (!endUser.get().getLogin().isLogin()) {
			throw new UserNotFoundException("first login to add fertilizer to the database");
		} else if (!(fertilizer.isPresent())) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + fertilizerId + " is not found");
		} else {
			fertilizer.get().setFertilizerPrice(price);
		}
		return fertilizerRepo.save(fertilizer.get());
	}

	/**
	 * Updates the price of existing fertilizer of given name.
	 * 
	 * @param userId
	 * @param name
	 * @param Price
	 * @return Returns the updated fertilizer object from database.
	 */
	@Override
	public Fertilizer updatePriceByName(int userId, String name, double price) {

		Fertilizer fertilizer = fertilizerRepo.findByFertilizerName(name);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (!endUser.get().getLogin().isLogin()) {
			throw new UserNotFoundException("first login to add fertilizer to the database");
		} else if (fertilizer == null) {
			throw new FertilizerNotFoundException("Fertilizer with the given name: " + name + " does not exist");
		}
		fertilizer.setFertilizerPrice(price);
		return fertilizerRepo.save(fertilizer);
	}

	/**
	 * Updates price and quantity of fertilizer of given id.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @param fertilizerDto
	 * @return Returns the updated fertilizer object from database.
	 */
	@Override
	public Fertilizer updatePriceAndQuantityById(int userId, int fertilizerId, double price, String quantity) {
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(fertilizerId);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (!endUser.get().getLogin().isLogin()) {
			throw new UserNotFoundException("first login to add fertilizer to the database");
		} else if (!fertilizer.isPresent()) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + fertilizerId + " is not found");
		}
		fertilizer.get().setFertilizerPrice(price);
		fertilizer.get().setFertilizerQuantity(quantity);
		return fertilizerRepo.save(fertilizer.get());
	}

	/**
	 * Deletes the fertilizer of given id from database.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @return Returns the deleted fertilizer.
	 */
	@Override
	public Fertilizer removeFertilizerById(int userId, int fertilizerId) {
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(fertilizerId);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (!endUser.get().getLogin().isLogin()) {
			throw new UserNotFoundException("first login to add fertilizer to the database");
		} else if (!(fertilizer.isPresent())) {
			throw new FertilizerNotFoundException("Fertilizer with the given id: " + fertilizerId + " is not found");
		}
		fertilizerRepo.deleteById(fertilizerId);
		return fertilizer.get();
	}

	/**
	 * Deletes the fertilizer of given name from database.
	 * 
	 * @param userId
	 * @param name
	 * @return Returns the deleted fertilizer.
	 */
	@Override
	public Fertilizer removeFertilizerByName(int userId, String name) {

		Fertilizer fertilizer = fertilizerRepo.findByFertilizerName(name);
		Optional<EndUser> endUser = endUserRepo.findById(userId);
		if (endUser.isEmpty()) {
			throw new UserNotFoundException("admin not found with the given id:" + userId);
		} else if (!endUser.get().isAdmin()) {
			throw new UserNotFoundException("only admin can add garden decor to the database");
		} else if (!endUser.get().getLogin().isLogin()) {
			throw new UserNotFoundException("first login to add fertilizer to the database");
		} else if (fertilizer == null) {
			throw new FertilizerNotFoundException("Fertilizer with the given name: " + name + " does not exist");
		}
		fertilizerRepo.deleteByName(name);
		return fertilizer;
	}

}
