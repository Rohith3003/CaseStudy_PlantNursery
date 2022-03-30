package com.cs.service;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cs.bean.GardenDecor;
import static org.junit.jupiter.api.Assertions.*;
/**
* This class provides basic JUnit test cases for GardenDecorService class.
* 
* @author Mayank Kumar(Employee ID: 46191925)
*
*/
@SpringBootTest
public class GardenDecorServiceTest 
{
	@Autowired
	IGardenDecorService gardenDecorServ;
	
	@Test
	@Disabled
	void addGardenDecor()
	{
		GardenDecor gardenDecor = new GardenDecor(101,"decor","image",10,"description");
		GardenDecor result = gardenDecorServ.addGardenDecor(1,gardenDecor);
		assertEquals(gardenDecor,result);
	}
	
	@Test
	@Disabled
	void getGardenDecorById()
	{
		GardenDecor result = gardenDecorServ.getGardenDecorById(9);
		assertEquals(9,result.getGardenDecorId());
	}
	
	@Test
	@Disabled
	void getAllGardenDecor()
	{
		List<GardenDecor> al = gardenDecorServ.getAllGardenDecor();
		assertEquals(4,al.size());
	}
	
	@Test
	@Disabled
	void updateGardenDecorNameById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorNameById(1,9,"Fountain");
		assertEquals("Fountain",result.getGardenDecorName());
	}
	
	@Test
	@Disabled
	void updateGardenDecorPriceById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorPriceById(1,9,200);
		assertEquals(200,result.getGardenDecorPrice());
	}
	
	@Test
	@Disabled
	void updateGardenDecorDescriptionById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorDescriptionById(1,101,"description");
		assertEquals("description",result.getGardenDecorDescription());
	}
	
	@Test
	@Disabled
	void updateGardenDecorImageById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorImageById(1,101,"image");
		assertEquals("image",result.getGardenDecorImage());
	}
	
	@Test
	@Disabled
	void deleteGardenDecorById()
	{
		GardenDecor result = gardenDecorServ.deleteGardenDecorById(1,101);
		assertEquals(101,result.getGardenDecorId());
	}
	
}
