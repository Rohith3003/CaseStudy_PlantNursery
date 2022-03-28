package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.Planter;
import com.cs.repository.IPlanterRepository;
import com.cs.bean.Type;

@ExtendWith(SpringExtension.class)
public class MockitoPlanterServiceTest {

	@InjectMocks
	PlanterServiceImpl planterService;
	
	@MockBean
	IPlanterRepository planterRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	Planter planter;
	Planter returned_planter;
	@Test 
	public void addPlanterTest()
	{
		planter=new Planter();
		planter.setCategory(Type.CERMAIC_POT);
		planter.setDescription("This is Ceramic type pot");
		planter.setName("Cream Stripes M");
		planter.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		planter.setPrice(650);
		Mockito.when(planterRepo.save(planter)).thenReturn(planter);
		returned_planter=planterService.addPlanter(planter);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(650, returned_planter.getPrice());
	}
	
	@Test
	public void getPlanterByIdTest()
	{
		planter=new Planter();
		planter.setCategory(Type.PLASTIC_POT);
		planter.setDescription("Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.");
		planter.setName("Brown M plain");
		planter.setPhotoLoc("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg");
		planter.setPrice(800);
		Mockito.when(planterRepo.findById(66)).thenReturn(Optional.of(planter));
		returned_planter=planterService.getPlanterById(66);
		assertEquals("Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.", returned_planter.getDescription());
		assertEquals(Type.PLASTIC_POT, returned_planter.getCategory());
		assertEquals("Brown M plain", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg", returned_planter.getPhotoLoc());
		assertEquals(800, returned_planter.getPrice());
	}
	
	@Test
	public void getPlanterByNameTest()
	{
		planter=new Planter();
		planter.setCategory(Type.CERMAIC_POT);
		planter.setDescription("This is Ceramic type pot");
		planter.setName("Cream Stripes M");
		planter.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		planter.setPrice(650);
		Mockito.when(planterRepo.getByName("Cream Stripes M")).thenReturn(planter);
		returned_planter=planterService.getPlanterByName("Cream Stripes M");
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(650, returned_planter.getPrice());
	}
	
	@Test
	public void deletePlanterByIdTest()
	{
		planter=new Planter();
		planter.setCategory(Type.CERMAIC_POT);
		planter.setDescription("This is Ceramic type pot");
		planter.setName("Cream Stripes M");
		planter.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		planter.setPrice(650);
		//Mockito.when(planterService.deletePlanterById(66)).thenReturn(planter);
		Mockito.when(planterRepo.findById(66)).thenReturn(Optional.of(planter));
		Mockito.doNothing().when(planterRepo).delete(planter);
		returned_planter=planterService.deletePlanterById(66);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(650, returned_planter.getPrice());
	}
	
	@Test
	public void updatePlanterPrice()
	{
		planter=new Planter();
		planter.setCategory(Type.CERMAIC_POT);
		planter.setDescription("This is Ceramic type pot");
		planter.setName("Cream Stripes M");
		planter.setPhotoLoc("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg");
		planter.setPrice(777);
		Mockito.when(planterRepo.findById(66)).thenReturn(Optional.of(planter));
		Mockito.when(planterRepo.save(planter)).thenReturn(planter);
		returned_planter=planterService.updatePlanterPrice(66,777);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(777, returned_planter.getPrice());
	}
}
