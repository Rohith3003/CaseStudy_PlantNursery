package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.EndUser;
import com.cs.bean.Login;
import com.cs.bean.Planter;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.IPlanterRepository;
import com.cs.bean.Type;
import com.cs.dto.PlanterDto;
/**
 * Test cases for planter service implementation using Mockito
 * @author Hemanth
 *
 */
@ExtendWith(SpringExtension.class)
public class MockitoPlanterServiceTest {

	@InjectMocks
	PlanterServiceImpl planterService;
	
	@MockBean
	IPlanterRepository planterRepo;
	
	@MockBean
	IEndUserRepository endUserRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	Planter planter;
	Planter returned_planter;
	
	/**
	 * Mockito test case to test the add planter functionality of
	 * PlanterService class.
	 */
	@Test 
	public void addPlanterTest()
	{
		planter=new Planter(5,"https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg","Cream Stripes M",Type.CERMAIC_POT,"This is Ceramic type pot",650);
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(planterRepo.save(planter)).thenReturn(planter);
		returned_planter=planterService.addPlanter(planter,1);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(650, returned_planter.getPrice());
	}
	
	/**
	 * Mockito test case to test the get planter by id functionality of
	 * PlanterService class.
	 */
	@Test
	public void getPlanterByIdTest()
	{
		planter=new Planter(6,"https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg","Brown M plain",Type.PLASTIC_POT,"Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.",800);
		Mockito.when(planterRepo.findById(6)).thenReturn(Optional.of(planter));
		returned_planter=planterService.getPlanterById(6);
		assertEquals("Kraft seeds have always believed in sustainable development of environment by believing in growing a seed a house.", returned_planter.getDescription());
		assertEquals(Type.PLASTIC_POT, returned_planter.getCategory());
		assertEquals("Brown M plain", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg", returned_planter.getPhotoLoc());
		assertEquals(800, returned_planter.getPrice());
	}
	
	/**
	 * Mockito test case to test the get planter by name functionality of
	 * PlanterService class.
	 */
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
	
	/**
	 * Mockito test case to test the delete planter by id functionality of
	 * PlanterService class.
	 */
	@Test
	public void deletePlanterByIdTest()
	{
		planter=new Planter(5,"https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg","Cream Stripes M",Type.CERMAIC_POT,"This is Ceramic type pot",650);
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(planterRepo.findById(5)).thenReturn(Optional.of(planter));
		Mockito.doNothing().when(planterRepo).delete(planter);
		returned_planter=planterService.deletePlanterById(5,1);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(650, returned_planter.getPrice());
	}
	
	/**
	 * Mockito test case to test the update planter price functionality of
	 * PlanterService class.
	 */
	@Test
	public void updatePlanterPrice()
	{
		planter=new Planter(5,"https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg","Cream Stripes M",Type.CERMAIC_POT,"This is Ceramic type pot",650);
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(planterRepo.findById(5)).thenReturn(Optional.of(planter));
		Mockito.when(planterRepo.save(planter)).thenReturn(planter);
		returned_planter=planterService.updatePlanterPrice(5,777,1);
		assertEquals("This is Ceramic type pot", returned_planter.getDescription());
		assertEquals(Type.CERMAIC_POT,returned_planter.getCategory());
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals("https://m.media-amazon.com/images/I/81wOdvLuauL._SL1500_.jpg", planter.getPhotoLoc());
		assertEquals(777, returned_planter.getPrice());
	}
	
	/**
	 * Mockito test case to test the get all planters functionality of
	 * PlanterService class.
	 */
	@Test
	public void getAllPlantersTest()
	{	List<PlanterDto> planters= new ArrayList<>();
		PlanterDto planter1=new PlanterDto("Cream Stripes M","https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg",650);
		PlanterDto planter2=new PlanterDto("Brown M plain","https://m.media-amazon.com/images/I/71v16h4eX7L._SX679_.jpg",800);
		planters.add(planter1);
		planters.add(planter2);
		Mockito.when(planterService.getAllPlanters()).thenReturn(planters);
		List<PlanterDto> returned_planters=planterService.getAllPlanters();
		assertEquals(2, returned_planters.size());
	}
	
	/**
	 * Mockito test case to test the update planter photo by Id functionality of
	 * PlanterService class.
	 */
	@Test
	public void updatePlanterPhotoTest()
	{
		planter=new Planter(5,"https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg","Cream Stripes M",Type.CERMAIC_POT,"This is Ceramic type pot",650);
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(planterRepo.findById(5)).thenReturn(Optional.of(planter));
		Mockito.when(planterRepo.save(planter)).thenReturn(planter);
		Planter returned_planter=planterService.updatePlanterPhoto(5, "https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg",1);
		assertEquals(5, returned_planter.getPlanterId());
		assertEquals("https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg", returned_planter.getPhotoLoc());
	}
	
	/**
	 * Mockito test case to test the delete planter by name functionality of
	 * PlanterService class.
	 */
	@Test
	public void deletePlanterByNameTest()
	{
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		planter=new Planter(5,"https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg","Cream Stripes M",Type.CERMAIC_POT,"This is Ceramic type pot",650);
		Mockito.when(planterRepo.getByName("Cream Stripes M")).thenReturn(planter);
		Planter returned_planter=planterService.deletePlanterByName("Cream Stripes M",1);
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals(5, returned_planter.getPlanterId());
	}
	
	/**
	 * Mockito test case to test the update planter price by name functionality of
	 * PlanterService class.
	 */
	@Test
	public void updatePlanterPriceByNameTest()
	{	
		planter=new Planter(5,"https://m.media-amazon.com/images/I/71t0G89Pi-L._SX522_.jpg","Cream Stripes M",Type.CERMAIC_POT,"This is Ceramic type pot",650);
		EndUser endUser = new EndUser();
		Login login = new Login();
		login.setLogin(true);
		endUser.setId(1);
		endUser.setAdmin(true);
		endUser.setLogin(login);
		Mockito.when(endUserRepo.findById(1)).thenReturn(Optional.of(endUser));
		Mockito.when(planterRepo.getByName("Cream Stripes M")).thenReturn(planter);
		Mockito.when(planterRepo.save(planter)).thenReturn(planter);
		returned_planter=planterService.updatePlanterPrice("Cream Stripes M", 999,1);
		assertEquals("Cream Stripes M", returned_planter.getName());
		assertEquals(999, returned_planter.getPrice());
	}
}
