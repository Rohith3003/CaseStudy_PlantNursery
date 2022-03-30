package com.cs.service;

import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.cs.bean.GardenDecor;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class GardenDecorServiceTest 
{
	static int n;
	@Autowired
	IGardenDecorService gardenDecorServ;
	
	@Test
	@Disabled
	@Order(1) 
	void addGardenDecor()
	{
		GardenDecor gardenDecor = new GardenDecor();
		gardenDecor.setGardenDecorName("decor");
		gardenDecor.setGardenDecorImage("https://www.google.com");
		gardenDecor.setGardenDecorPrice(10);
		gardenDecor.setGardenDecorDescription("description");
		GardenDecor result = gardenDecorServ.addGardenDecor(1,gardenDecor);
		assertEquals(gardenDecor,result);
		n = result.getGardenDecorId();
	}
	
	@Test
	@Disabled
	@Order(2) 
	void getGardenDecorById()
	{
		GardenDecor result = gardenDecorServ.getGardenDecorById(n);
		assertEquals(n,result.getGardenDecorId());
	}
	
	@Test
	@Disabled
	@Order(3) 
	void getAllGardenDecor()
	{
		List<GardenDecor> al = gardenDecorServ.getAllGardenDecor();
		assertEquals(4,al.size());
	}
	
	@Test
	@Disabled
	@Order(4) 
	void updateGardenDecorNameById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorNameById(1,n,"Fountain");
		assertEquals("Fountain",result.getGardenDecorName());
	}
	
	@Test
	@Disabled
	@Order(5) 
	void updateGardenDecorPriceById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorPriceById(1,n,200);
		assertEquals(200,result.getGardenDecorPrice());
	}
	
	@Test
	@Disabled
	@Order(6) 
	void updateGardenDecorDescriptionById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorDescriptionById(1,n,"new description");
		assertEquals("description",result.getGardenDecorDescription());
	}
	
	@Test
	@Disabled
	@Order(7) 
	void updateGardenDecorImageById()
	{
		GardenDecor result = gardenDecorServ.updateGardenDecorImageById(1,n,"https://www.google.co.in");
		assertEquals("https://www.google.co.in",result.getGardenDecorImage());
	}
	
	@Test
	@Disabled
	@Order(8) 
	void deleteGardenDecorById()
	{
		GardenDecor result = gardenDecorServ.deleteGardenDecorById(1,n);
		assertEquals(n,result.getGardenDecorId());
	}
	
}
