package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Seed;


@SpringBootTest
public class SeedServiceTest {
	
	@Autowired
	ISeedService seedService;
	
	Seed returned_seed;
	@Test 
	@Disabled
	public void addSeedTest()
	{
		Seed seed=new Seed();

		seed.setDescription("Cauliflower seeds have always believed in sustainable development of environment by believing in growing a plant.");
		seed.setName("Cauliflower Seeds");
		//seed.setPhotoLoc("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg");
		seed.setPrice(500);
		returned_seed=seedService.addSeed(seed);
	}
	
	@Test
	@Disabled
	void getSeedById()
	{
		Seed result = seedService.getSeedById(101);
		assertEquals(101,result.getSeedId());
	}

	@Test
	@Disabled
	void deleteSeedById()
	{
		Seed result = seedService.deleteSeedById(101);
		assertEquals(101,result.getSeedId());
	}
	 @Test
	 @Disabled
	 void getSeedByName() {
		 Seed result= seedService.getSeedByName("Tomato Seed");
		 assertEquals(101,result.getName());
	 }
	 @Test
	 @Disabled
	 void updateSeedPrice()
	 {
		 Seed result= seedService.updateSeedPrice(101, 100);
		 assertEquals(101,result.getPrice());
	 }
	/*@Test
	@Disabled
	void updateSeedImageById()
	{
		Seed result = seedService.updateSeedImageById(1,101,"image");
		assertEquals("image",result.getSeedImage());
	}*/
	

	/*@Test
	//@Disabled
	public void getSeedByIdTest()
	{
		Seed returned_seed=seedService.getSeedById(69);
		assertEquals("Cauliflower seeds seeds have always believed in sustainable development of environment by believing in growing a plant.", returned_seed.getDescription());
		assertEquals("Cauliflower Seeds", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg", returned_seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}
	
	@Test
	public void getSeedByNameTest()
	{
		Seed returned_seed=seedService.getSeedByName("Tomato Seed");
		assertEquals("This is Tomato Seed", returned_seed.getDescription());
		assertEquals("Tomato Seed", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}
	
	@Test
	//@Disabled
	public void deleteSeedByIdTest()
	{
		Seed returned_seed=seedService.deleteSeedById(70);
		assertEquals("This is Tomato Seed", returned_seed.getDescription());
		assertEquals("Tomato Seed", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}
	
	@Test
	public void updateSeedPrice()
	{
		Seed returned_seed=seedService.updateSeedPrice(68,777);
		assertEquals("This is Tomato Seed", returned_seed.getDescription());
		assertEquals("Tomato Seed", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", returned_seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}*/
}
