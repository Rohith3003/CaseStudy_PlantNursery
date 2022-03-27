package com.cs.service;

import java.util.List;
import com.cs.bean.GardenDecor;

public interface IGardenDecorService 
{
	GardenDecor addGardenDecor(int id, GardenDecor gardenDecor);
	GardenDecor getGardenDecorById(int id);
	List<GardenDecor> getAllGardenDecor();
	GardenDecor updateGardenDecorNameById(int id,int gardenDecorId,String gardenDecorName);
	GardenDecor updateGardenDecorPriceById(int id,int gardenDecorId, double gardenDecorPrice);
	GardenDecor updateGardenDecorDescriptionById(int id,int gardenDecorId, String gardenDecorDescription);
	GardenDecor updateGardenDecorImageById(int id,int gardenDecorId, String gardenDecorImage);
	GardenDecor deleteGardenDecorById(int id, int gardenDecorId);
}
