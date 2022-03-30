package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Planter;
import com.cs.bean.Type;
import com.cs.dto.PlanterDto;

@SpringBootTest
public class PlanterServiceTest {
	
	@Autowired
	IPlanterService planterService;
	
	Planter returned_planter;
	
	/**
	 * JUnit test case to test the add planter functionality of
	 * PlanterService class.
	 */
	@Test 
	@Disabled
	public void addPlanterTest()
	{
		//Creating a planter object and setting it's attributes
		Planter planter=new Planter(5,"https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg","Cream Stripes M",Type.CERMAIC_POT,"This is Ceramic type pot",650);
//		Planter planter=new Planter(6,"https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg","Brown M plain",Type.PLASTIC_POT,"Kraft seeds have always delivered best",800);
		returned_planter=planterService.addPlanter(planter,1);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(650, returned_planter.getPrice());
	}
	
	/**
	 * JUnit test case to test the get planter by id functionality of
	 * PlanterService class.
	 */
	@Test
	//@Disabled
	public void getPlanterByIdTest()
	{
		returned_planter=planterService.getPlanterById(10);
		//Comparing all the attributes of returned product
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg", returned_planter.getPhotoLoc());
		assertEquals(555, returned_planter.getPrice());
	}
	
	/**
	 * JUnit test case to test the get planter by name functionality of
	 * PlanterService class.
	 */
	@Test
	//@Disabled
	public void getPlanterByNameTest()
	{
		Planter returned_planter=planterService.getPlanterByName("Cream Stripes M");
		//Comparing all the attributes of returned product
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg", returned_planter.getPhotoLoc());
		assertEquals(555, returned_planter.getPrice());
	}
	
	/**
	 * JUnit test case to test the delete planter by id functionality of
	 * PlanterService class.
	 */
	@Test
	//@Disabled
	public void deletePlanterByIdTest()
	{
		Planter returned_planter=planterService.deletePlanterById(10,1);
		//Comparing all the attributes of returned product
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg", returned_planter.getPhotoLoc());
		assertEquals(555, returned_planter.getPrice());
	}
	
	/**
	 * JUnit test case to test the update planter price functionality of
	 * PlanterService class.
	 */
	@Test
	//@Disabled
	public void updatePlanterPriceTest()
	{	//Updates the price and returns modified object
		Planter returned_planter=planterService.updatePlanterPrice(13,333,1);
		//Comparing all the attributes of returned product
		assertEquals("Iron Floor Set of 2.", returned_planter.getDescription());
		assertEquals(Type.PLASTIC_POT,returned_planter.getCategory());
		assertEquals("Iron pots dual long set", returned_planter.getName());
		assertEquals("https://5.imimg.com/data5/US/JS/ZH/SELLER-28215188/set-of-2-modern-planter-with-stand-500x500.jpg", returned_planter.getPhotoLoc());
		assertEquals(333, returned_planter.getPrice());
	}
	
	/**
	 * JUnit test case to test the get all planters functionality of
	 * PlanterService class.
	 */
	@Test
	public void getAllPlantersTest()
	{
		List<PlanterDto> planters=planterService.getAllPlanters();
		assertEquals(4, planters.size());
	}
	
	/**
	 * JUnit test case to test the update planter photo by Id functionality of
	 * PlanterService class.
	 */
	@Test
	public void updatePlanterPhotoTest()
	{
		Planter returned_planter=planterService.updatePlanterPhoto(13, "https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg",1);
		assertEquals(13, returned_planter.getPlanterId());
		assertEquals("https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg", returned_planter.getPhotoLoc());
	}
	
	/**
	 * JUnit test case to test the delete planter by name functionality of
	 * PlanterService class.
	 */
	@Test
	@Disabled
	public void deletePlanterByNameTest()
	{
		assertEquals(1, planterService.getAllPlanters().size());
		Planter returned_planter=planterService.deletePlanterByName("Cream Stripes M",1);
		assertEquals(0, planterService.getAllPlanters().size());
		assertEquals("Cream Stripes M", returned_planter.getName());
	}
	
	/**
	 * JUnit test case to test the update planter price by name functionality of
	 * PlanterService class.
	 */
	@Test
	public void updatePlanterPriceByNameTest()
	{
		Planter returned_planter=planterService.getPlanterByName("Faceted Modern");
		returned_planter=planterService.updatePlanterPrice("Faceted Modern", 999,1);
		assertEquals("Faceted Modern", returned_planter.getName());
		assertEquals(999, returned_planter.getPrice());
	}
}
