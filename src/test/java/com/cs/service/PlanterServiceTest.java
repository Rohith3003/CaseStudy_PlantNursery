package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Planter;
import com.cs.bean.Type;

@SpringBootTest
public class PlanterServiceTest {
	
	@Autowired
	IPlanterService planterService;
	
	Planter returned_planter;
	@Test 
	@Disabled
	public void addPlanterTest()
	{
		//Creating a planter object and setting it's attributes
		Planter planter=new Planter();
//		planter.setCategory(Type.CERMAIC_POT);
//		planter.setDescription("This is Ceramic type pot");
//		planter.setName("Cream Stripes M");
//		planter.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
//		planter.setPrice(650);
		planter.setCategory(Type.PLASTIC_POT);
		planter.setDescription("Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.");
		planter.setName("Brown M plain");
		planter.setPhotoLoc("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg");
		planter.setPrice(800);
		returned_planter=planterService.addPlanter(planter);
//		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
//		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
//		assertEquals("Cream Stripes M", returned_planter.getName());
//		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
//		assertEquals(650, returned_planter.getPrice());
	}
	
	@Test
	//@Disabled
	public void getPlanterByIdTest()
	{
		Planter returned_planter=planterService.getPlanterById(69);
		//Comparing all the attributes of returned product
		assertEquals("Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.", returned_planter.getDescription());
		assertEquals(Type.PLASTIC_POT, returned_planter.getCategory());
		assertEquals("Brown M plain", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg", returned_planter.getPhotoLoc());
		assertEquals(800, returned_planter.getPrice());
	}
	
	@Test
	public void getPlanterByNameTest()
	{
		Planter returned_planter=planterService.getPlanterByName("Cream Stripes M");
		//Comparing all the attributes of returned product
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_planter.getPhotoLoc());
		assertEquals(555, returned_planter.getPrice());
	}
	
	@Test
	@Disabled
	public void deletePlanterByIdTest()
	{
		Planter returned_planter=planterService.deletePlanterById(68);
		//Comparing all the attributes of returned product
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_planter.getPhotoLoc());
		assertEquals(555, returned_planter.getPrice());
	}
	
	@Test
	//@Disabled
	public void updatePlanterPrice()
	{	//Updates the price and returns modified object
		Planter returned_planter=planterService.updatePlanterPrice(68,555);
		//Comparing all the attributes of returned product
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_planter.getPhotoLoc());
		assertEquals(555, returned_planter.getPrice());
	}
	
	@Test
	public void getAllPlantersTest()
	{
		List<Planter> planters=planterService.getAllPlanters();
		assertEquals(2, planters.size());
	}
}
