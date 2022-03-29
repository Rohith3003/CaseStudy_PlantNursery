package com.cs.service;

import java.util.List;

import com.cs.bean.Fertilizer;

/**
 * This Interface is used to define the services provided to
 * FertilizerController so that we can add, delete, update and retrieve the
 * fertilizer into or from database
 * 
 * @author Rohith(Employee id: 46191986)
 *
 */
public interface IFertilizerService {

	/**
	 * Adds new fertilizer to the database.
	 * 
	 * @param userId
	 * @param fertilizer
	 * @return Returns the fertilizer object which is persisted in database.
	 */
	Fertilizer addFertilizer(int userId, Fertilizer fertilizer);

	/**
	 * Retrieves the fertilizer of given id from database.
	 * 
	 * @param id
	 * @return Returns the fertilizer of given id.
	 */
	Fertilizer getFertilizerById(int id);

	/**
	 * Retrieves the fertilizer of given name from database.
	 * 
	 * @param name
	 * @return Returns the fertilizer of given name.
	 */
	Fertilizer getFertilizerByName(String name);

	/**
	 * Retrieves the list of all available fertilizers from database.
	 * 
	 * @return Returns the list of fertilizers.
	 */
	List<Fertilizer> getAllFertilizers();

	/**
	 * Updates the price of existing fertilizer of given id.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @param price
	 * @return Returns the updated fertilizer object from database.
	 */
	Fertilizer updatePriceById(int userId, int fertilizerId, double price);

	/**
	 * Updates the price of existing fertilizer of given name.
	 * 
	 * @param userId
	 * @param name
	 * @param Price
	 * @return Returns the updated fertilizer object from database.
	 */
	Fertilizer updatePriceByName(int userId, String name, double price);

	/**
	 * Updates price and quantity of fertilizer of given id.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @param fertilizerDto
	 * @return Returns the updated fertilizer object from database.
	 */
	Fertilizer updatePriceAndQuantityById(int userId, int fertilizerId, double price, String quantity);

	/**
	 * Deletes the fertilizer of given id from database.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @return Returns the deleted fertilizer.
	 */
	Fertilizer removeFertilizerById(int userId, int fertilizerId);

	/**
	 * Deletes the fertilizer of given name from database.
	 * 
	 * @param userId
	 * @param name
	 * @return Returns the deleted fertilizer.
	 */
	Fertilizer removeFertilizerByName(int userId, String name);
}
