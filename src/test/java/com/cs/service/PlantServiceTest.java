package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Plant;


@SpringBootTest
public class PlantServiceTest {
	
	@Autowired
	IPlantService PlantService;
	
	Plant returned_Plant;
	@Test 
	@Disabled
	public void addPlantTest()
	{
		Plant Plant=new Plant();

		Plant.setDescription("This is a corriander plant");
		Plant.setName("Coriander Plant");
		Plant.setPrice(500);
		returned_Plant=PlantService.addPlant(Plant);
	}
	
	@Test
	@Disabled
	void getPlantById()
	{
		Plant result = PlantService.getPlantById(101);
		assertEquals(101,result.getPlantId());
	}

	 @Test
	 @Disabled
	 void getPlantByName() {
		 Plant result= PlantService.getPlantByName("Tomato Plant");
		 assertEquals(101,result.getName());
	 }
	 @Test
	 @Disabled
	 void updatePlantPrice()
	 {
		 Plant result= PlantService.updatePlantPrice(101, 100);
		 assertEquals(101,result.getPrice());
	 }

}
