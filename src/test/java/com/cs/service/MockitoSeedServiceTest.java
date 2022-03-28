package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.Seed;
import com.cs.repository.ISeedRepository;


@ExtendWith(SpringExtension.class)
public class MockitoSeedServiceTest {

	@InjectMocks
	SeedServiceImpl seedService;
	
	@MockBean
	ISeedRepository seedRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	Seed seed;
	Seed returned_seed;
	@Test 
	public void addSeedTest()
	{
		seed=new Seed();
		seed.setDescription("This is Tomato Seed");
		seed.setName("Tomato Seed");
		//seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed.setPrice(500);
		Mockito.when(seedRepo.save(seed)).thenReturn(seed);
		returned_seed=seedService.addSeed(seed);
		assertEquals("This is Tomato Seed", returned_seed.getDescription());
		assertEquals("Tomato Seed", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}
	
	@Test
	public void getSeedByIdTest()
	{
		seed=new Seed();
		seed.setDescription("Cauliflower seeds have always believed in sustainable development of environment by believing in growing a plant.");
		seed.setName("Cauliflower seeds");
		//seed.setPhotoLoc("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg");
		seed.setPrice(500);
		Mockito.when(seedRepo.findById(66)).thenReturn(Optional.of(seed));
		returned_seed=seedService.getSeedById(66);
		assertEquals("Cauliflower seeds have always believed in sustainable development of environment by believing in growing a plant.", returned_seed.getDescription());
		assertEquals("Cauliflower seeds", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg", returned_seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}
	
	@Test
	public void getSeedByNameTest()
	{
		seed=new Seed();
		seed.setDescription("This is Ceramic type pot");
		seed.setName("Cream Stripes M");
		//seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed.setPrice(650);
		Mockito.when(seedRepo.getByName("Cream Stripes M")).thenReturn(seed);
		returned_seed=seedService.getSeedByName("Cream Stripes M");
		assertEquals("This is Ceramic type pot", returned_seed.getDescription());
		assertEquals("Cream Stripes M", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(650, returned_seed.getPrice());
	}
	
	/*@Test
	public void deleteSeedByIdTest()
	{
		Seed seed1;
		seed1=new Seed();
		seed1.setDescription("This is Ceramic type pot");
		seed1.setName("Cream Stripes M");
		//seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed1.setPrice(650);
		Seed responseSeed=new Seed();
		responseSeed=seedService.deleteSeedById(66);
		//Mockito.when(seedRepo.delete(seed)).thenReturn(null);
		Mockito.doNothing().when(seedRepo).delete(seed1);
		//returned_seed=seedService.deleteSeedById(66);
		assertEquals(seed.getDescription(), responseSeed.getDescription());
		//System.out.println(seed1.getName()+" "+ responseSeed.getClass());
		assertEquals(seed1.getName(), responseSeed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(seed1.getPrice(), responseSeed.getPrice());
	}*/
	/*@Test
	public void deleteSeedByIdTest2()
	{
		Seed seed1;
		seed1=new Seed();
		seed1.setDescription("This is Ceramic type pot");
		seed1.setName("Cream Stripes M");
		seed1.setPrice(650);
		Mockito.doNothing().when(seedRepo).delete(seed1);
		verify(seedRepo,times(1)).delete(seed1);
		
	}*/
	@Test
	public void deleteSeedByIdTest()
	{
		seed=new Seed();
		//seed.setCategory(Type.CERMAIC_POT);
		seed.setDescription("This is Ceramic type pot");
		seed.setName("Cream Stripes M");
		//seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed.setPrice(650);
		Mockito.when(seedService.deleteSeedById(66)).thenReturn(seed);
		returned_seed=seedService.deleteSeedById(66);
		assertEquals("This is Ceramic type pot", returned_seed.getDescription());
		//assertEquals(Type.CERMAIC_POT,returned_seed.getCategory());
		assertEquals("Cream Stripes M", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(650, returned_seed.getPrice());
	}
	
	@Test
	public void updateSeedPrice()
	{
		seed=new Seed();
		seed.setDescription("This is Ceramic type pot");
		seed.setName("Cream Stripes M");
		//seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed.setPrice(777);
		Mockito.when(seedRepo.getById(45)).thenReturn(seed);
		Mockito.when(seedRepo.save(seed)).thenReturn(seed);
		returned_seed=seedService.updateSeedPrice(45,777);
		assertEquals("This is Ceramic type pot", returned_seed.getDescription());
		assertEquals("Cream Stripes M", returned_seed.getName());
		//assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(777, returned_seed.getPrice());
	}
}
