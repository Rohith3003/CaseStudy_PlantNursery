package com.cs.service;

import java.util.List;

import com.cs.bean.Fertilizer;

/**
 * This Interface is used to define the services provided to
 * FertilizerController so that we can add, delete, update and retrieve the
 * fertilizer into or from database
 * 
 * @author Rohith(Employee id: 46191986)
 * @version 1.0.0
 * @since 28-03-2022
 *
 */
public interface IFertilizerService {

	Fertilizer addFertilizer(int userId, Fertilizer fertilizer);

	Fertilizer removeFertilizerById(int userId, int fertilizerId);

	Fertilizer getFertilizerById(int id);

	Fertilizer getFertilizerByName(String name);

	List<Fertilizer> getAllFertilizers();

	Fertilizer updatePriceById(int userId, int fertilizerId, double price);

	Fertilizer updatePriceByName(int userId, String name, double price);

	Fertilizer updatePriceAndQuantityById(int userId, int fertilizerId, double price, String quantity);

	Fertilizer removeFertilizerByName(int userId, String name);
}
