package com.cs.service;

import java.util.List;

import com.cs.bean.Fertilizer;

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
