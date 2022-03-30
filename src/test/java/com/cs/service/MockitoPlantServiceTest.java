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

import com.cs.bean.Plant;
import com.cs.repository.IPlantRepository;


@ExtendWith(SpringExtension.class)
public class MockitoPlantServiceTest {

	@InjectMocks
	PlantServiceImpl PlantService;
	
	@MockBean
	IPlantRepository PlantRepo;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	Plant Plant;
	Plant returned_Plant;
	@Test 
	public void addPlantTest()
	{
		Plant=new Plant();
		Plant.setDescription("This is Tomato Plant");
		Plant.setName("Tomato Plant");
		Plant.setPrice(500);
		Mockito.when(PlantRepo.save(Plant)).thenReturn(Plant);
		returned_Plant=PlantService.addPlant(Plant);
		assertEquals("This is Tomato Plant", returned_Plant.getDescription());
		assertEquals("Tomato Plant", returned_Plant.getName());
		assertEquals(500, returned_Plant.getPrice());
	}

	@Test
	public void getPlantByNameTest()
	{
		Plant=new Plant();
		Plant.setDescription("This is Rose plant");
		Plant.setName("Rose plant");
		Plant.setPrice(650);
		Mockito.when(PlantRepo.getByName("This is Rose plant")).thenReturn(Plant);
		returned_Plant=PlantService.getPlantByName("Rose plant");
		assertEquals("This is Rose plant", returned_Plant.getDescription());
		assertEquals("Rose plant", returned_Plant.getName());
		assertEquals(650, returned_Plant.getPrice());
	}


	@Test
	public void updatePlantPrice()
	{
		Plant=new Plant();
		Plant.setDescription("This is flax Plant");
		Plant.setName("Flax Plants");
		Plant.setPrice(777);
		Mockito.when(PlantRepo.findById(66)).thenReturn(Optional.of(Plant));
		Mockito.when(PlantRepo.save(Plant)).thenReturn(Plant);
		returned_Plant=PlantService.updatePlantPrice(66,777);
		assertEquals("This is flax Plant", returned_Plant.getDescription());
		assertEquals("Flax Plants", returned_Plant.getName());
		assertEquals(777, returned_Plant.getPrice());
	}
	
	
}
