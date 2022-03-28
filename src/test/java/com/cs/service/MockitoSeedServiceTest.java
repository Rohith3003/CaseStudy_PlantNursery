package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
		seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed.setPrice(500);
		Mockito.when(seedRepo.save(seed)).thenReturn(seed);
		returned_seed=seedService.addSeed(seed);
		assertEquals("This is Tomato Seed", returned_seed.getDescription());
		assertEquals("Tomato Seed", returned_seed.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}
	
	@Test
	public void getSeedByIdTest()
	{
		seed=new Seed();
		seed.setDescription("Cauliflower seeds have always believed in sustainable development of environment by believing in growing a plant.");
		seed.setName("Cauliflower seeds");
		seed.setPhotoLoc("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg");
		seed.setPrice(500);
		Mockito.when(seedRepo.findById(66)).thenReturn(Optional.of(seed));
		returned_seed=seedService.getSeedById(66);
		assertEquals("Cauliflower seeds have always believed in sustainable development of environment by believing in growing a plant.", returned_seed.getDescription());
		assertEquals("Cauliflower seeds", returned_seed.getName());
		assertEquals("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg", returned_seed.getPhotoLoc());
		assertEquals(500, returned_seed.getPrice());
	}
	
	@Test
	public void getSeedByNameTest()
	{
		seed=new Seed();
		seed.setDescription("This is Ceramic type pot");
		seed.setName("Cream Stripes M");
		seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed.setPrice(650);
		Mockito.when(seedRepo.getByName("Cream Stripes M")).thenReturn(seed);
		returned_seed=seedService.getSeedByName("Cream Stripes M");
		assertEquals("This is Ceramic type pot", returned_seed.getDescription());
		assertEquals("Cream Stripes M", returned_seed.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(650, returned_seed.getPrice());
	}

	@Test
	void deleteSeedById() {
		int id = 10;
		Seed seed = new Seed(10, "Rajma", 100, 1000, "Bean type Seed", "https://5.imimg.com/data5/YD/KX/IT/SELLER-30286003/lobia-beans-seeds-500x500.jpg");
	
		// Return seed
		Mockito.when(seedRepo.findById(10)).thenReturn(Optional.of(seed));
		
		// Handling void methods
		Mockito.doNothing().when(seedRepo).deleteById(10);
		
		// delete seed
		seedService.deleteSeedById(id);
	}
	@Test
	public void updateSeedPrice()
	{
		seed=new Seed();
		seed.setDescription("This is flax seed");
		seed.setName("Flax Seeds");
		seed.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		seed.setPrice(777);
		Mockito.when(seedRepo.findById(66)).thenReturn(Optional.of(seed));
		Mockito.when(seedRepo.save(seed)).thenReturn(seed);
		returned_seed=seedService.updateSeedPrice(66,777);
		assertEquals("This is flax seed", returned_seed.getDescription());
		assertEquals("Flax Seeds", returned_seed.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", seed.getPhotoLoc());
		assertEquals(777, returned_seed.getPrice());
	}
	
	
}
