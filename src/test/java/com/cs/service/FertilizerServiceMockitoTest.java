package com.cs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.Fertilizer;
import com.cs.repository.IFertilizerRepository;


@ExtendWith(SpringExtension.class)
class FertilizerServiceMockitoTest {
	
	
	@InjectMocks
	FertilizerServiceImp fertilizerService;
	
	@MockBean
	IFertilizerRepository fertilizerRepo;
	
	@BeforeEach
	void init()
	{
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void getAllFertilizersTest() {
		
		List<Fertilizer> fertilizers = new ArrayList<Fertilizer>();
		Fertilizer fertilizer1 = new Fertilizer(2,"cow manure","www.google.com/cowManure",250,"It is an organic fertilizer and manure containing essential nutrients for healthy growth of plants.","1KG");
		Fertilizer fertilizer2 = new Fertilizer(3,"Leaf mould","www.google.com/leafMould",189,"It is a form of compost exclusively made by the fungal & bacterial breakdown of dry leaves. Leaf mould is good quality humus.","1KG");
		Fertilizer fertilizer3 = new Fertilizer(1,"compost","www.google.com/compost",49.99,"The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.","1KG");
		Fertilizer fertilizer4 = new Fertilizer(5,"plant food","www.google.com/plantfood",549.99," Plant food is a manure or mixture of nitrates which are added to soil, to make fertile.","2KG");
		fertilizers.add(fertilizer1);
		fertilizers.add(fertilizer2);
		fertilizers.add(fertilizer3);
		fertilizers.add(fertilizer4);

		Mockito.when(fertilizerRepo.findAll()).thenReturn(fertilizers);
		
		List<Fertilizer> list = fertilizerService.getAllFertilizers();
		assertEquals(4,list.size());
		
	}
	
	@Test
	public void getFertilizerByIdTest()
	{
		Fertilizer fertilizer = new Fertilizer(1,"compost","www.google.com/compost",49.99,"The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.","1KG");
		
		//mocking fertilizer object
		Mockito.when(fertilizerRepo.findById(1)).thenReturn(Optional.of(fertilizer));
		
		Fertilizer fertilizer1 = fertilizerService.getFertilizerById(1);
		
		//verification of result
		assertEquals(1,fertilizer1.getFertilizerId());
		assertEquals(49.99,fertilizer1.getFertilizerPrice());
		assertEquals("compost",fertilizer1.getFertilizerName());
		assertEquals("www.google.com/compost",fertilizer1.getFertilizerImage());
		assertEquals("The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.",fertilizer1.getFertilizerDescription());
		assertEquals("1KG",fertilizer1.getFertilizerQuantity());
	}
	
	@Test
	public void getFertilizerByNameTest()
	{
		Fertilizer fertilizer = new Fertilizer(1,"compost","www.google.com/compost",49.99,"The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.","1KG");
		
		Mockito.when(fertilizerRepo.findByFertilizerName("compost")).thenReturn(fertilizer);
		
		Fertilizer fertilizer1 = fertilizerService.getFertilizerByName("compost");
		
		//verification of result
		assertEquals(1,fertilizer1.getFertilizerId());
		assertEquals(49.99,fertilizer1.getFertilizerPrice());
		assertEquals("compost",fertilizer1.getFertilizerName());
		assertEquals("www.google.com/compost",fertilizer1.getFertilizerImage());
		assertEquals("The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.",fertilizer1.getFertilizerDescription());
		assertEquals("1KG",fertilizer1.getFertilizerQuantity());

	}
	
	@Test
	public void updatePriceByIdTest()
	{
		Fertilizer fertilizer = new Fertilizer(3,"Leaf mould","www.google.com/leafMould",189,"It is a form of compost exclusively made by the fungal & bacterial breakdown of dry leaves. Leaf mould is good quality humus.","1KG");
		Fertilizer fertilizer2 = new Fertilizer(3,"Leaf mould","www.google.com/leafMould",200,"It is a form of compost exclusively made by the fungal & bacterial breakdown of dry leaves. Leaf mould is good quality humus.","1KG");
		
		Mockito.when(fertilizerRepo.findById(3)).thenReturn(Optional.of(fertilizer));
		Fertilizer fertilizer1 = fertilizerService.getFertilizerById(3);
		assertEquals(3,fertilizer1.getFertilizerId());
		assertEquals(189,fertilizer1.getFertilizerPrice());
		
		Mockito.when(fertilizerRepo.save(fertilizer1)).thenReturn(fertilizer2);
		Fertilizer fertilizer3 = fertilizerService.updatePriceById(23,3, 200);
		assertEquals(3,fertilizer3.getFertilizerId());
		assertEquals(200,fertilizer3.getFertilizerPrice());
	}
	
	@Test
	public void updatePriceByNameTest()
	{
		Fertilizer fertilizer = new Fertilizer(3,"Leaf mould","www.google.com/leafMould",189,"It is a form of compost exclusively made by the fungal & bacterial breakdown of dry leaves. Leaf mould is good quality humus.","1KG");
		Fertilizer fertilizer2 = new Fertilizer(3,"Leaf mould","www.google.com/leafMould",200,"It is a form of compost exclusively made by the fungal & bacterial breakdown of dry leaves. Leaf mould is good quality humus.","1KG");
		
		Mockito.when(fertilizerRepo.findByFertilizerName("Leaf mould")).thenReturn(fertilizer);
		Fertilizer fertilizer1 = fertilizerService.getFertilizerByName("Leaf mould");
		assertEquals("Leaf mould",fertilizer1.getFertilizerName());
		assertEquals(189,fertilizer1.getFertilizerPrice());
		
		Mockito.when(fertilizerRepo.save(fertilizer1)).thenReturn(fertilizer2);
		Fertilizer fertilizer3 = fertilizerService.updatePriceByName(23,"Leaf mould", 200);
		assertEquals("Leaf mould",fertilizer3.getFertilizerName());
		assertEquals(200,fertilizer3.getFertilizerPrice());
	}

//	@Test
//	public void removeFertilizerByIdTest()
//	{
//		Fertilizer fertilizer = new Fertilizer(3,"Leaf mould","www.google.com/leafMould",189,"It is a form of compost exclusively made by the fungal & bacterial breakdown of dry leaves. Leaf mould is good quality humus.","1KG");
//		Mockito.when(fertilizerRepo.findById(3)).thenReturn(Optional.of(fertilizer));
//		
//		fertilizerService.removeFertilizerById(3);
//		
//	}
	
//	@Test
//	public void removeFertilizerByNameTest()
//	{
//		Fertilizer fertilizer = new Fertilizer(3,"Leaf mould","www.google.com/leafMould",189,"It is a form of compost exclusively made by the fungal & bacterial breakdown of dry leaves. Leaf mould is good quality humus.","1KG");
//		Mockito.when(fertilizerRepo.findByName("Leaf mould")).thenReturn(fertilizer);
//		assertEquals("Leaf mould",fertilizer.getName());
//		
//		Fertilizer fertilizer1 = fertilizerService.removeFertilizerByName("Leaf mould");
//		assertEquals(fertilizer, fertilizer1);
//		
//	}
}
