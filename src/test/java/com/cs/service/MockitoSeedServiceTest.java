package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.EndUser;
import com.cs.bean.Seed;
import com.cs.bean.Seed;
import com.cs.bean.Seed;
import com.cs.bean.Seed;
import com.cs.bean.Seed;
import com.cs.bean.Login;
import com.cs.bean.Seed;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.ISeedRepository;


@ExtendWith(SpringExtension.class)
public class MockitoSeedServiceTest {

	@InjectMocks
	SeedServiceImpl seedService;
	
	@MockBean
	ISeedRepository seedRepo;
	
	@MockBean
	IEndUserRepository endUserRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	Seed seed;
	Seed returned_seed;
	@Test 
	public void addSeedTest()
	{
		Seed seed = new Seed(1,"name","image",100,100,"description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(seedRepo.save(seed)).thenReturn(seed);
		Seed result = seedService.addSeed(seed,1);
		assertEquals(result,seed);
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
		Seed seed = new Seed(1,"name","image",100,100,"description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(seedRepo.findById(1)).thenReturn(Optional.of(seed));
		Mockito.doNothing().when(seedRepo).deleteById(1);
		Seed result = seedService.deleteSeedById(1,1);
		assertEquals(result,seed);
	}
	@Test
	public void updateSeedPrice()
	{
		Seed seed1 = new Seed(1,"name","image",10,100,"description");
		Seed seed2 = new Seed(1,"name","image",20,100,"description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(seedRepo.findById(1)).thenReturn(Optional.of(seed1));
		Mockito.when(seedRepo.save(seed1)).thenReturn(seed2);
		Seed result = seedService.getSeedById(1);
		assertEquals(10,result.getPrice());
		result = seedService.updateSeedPrice(1,1,1);
		assertEquals(20,result.getPrice());

	}
	
	@Test
	void getAllSeeds()
	{
		List<Seed> al = new ArrayList<Seed>();
		Seed seed1 = new Seed(1,"name1","image1",10,100,"description1");
		Seed seed2 = new Seed(2,"name2","image2",20,110,"description2");
		Seed seed3 = new Seed(3,"name3","image3",30,200,"description3");
		al.add(seed1);
		al.add(seed2);
		al.add(seed3);
		Mockito.when(seedRepo.findAll()).thenReturn(al);
		List<Seed> result= seedService.getAllSeeds();
		assertEquals(3,result.size());
	}
	
	@Test
	void updateSeedPhoto()
	{
		Seed seed1 = new Seed(1,"name","image1",10,100,"description");
		Seed seed2 = new Seed(1,"name","image2",10,100,"description");
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(seedRepo.findById(1)).thenReturn(Optional.of(seed1));
		Mockito.when(seedRepo.save(seed1)).thenReturn(seed2);
		Seed result = seedService.getSeedById(1);
		assertEquals("image1",result.getPhotoLoc());
		result = seedService.updateSeedPhoto(1,"image2",1);
		assertEquals("image2",result.getPhotoLoc());
	}
	
	
}
