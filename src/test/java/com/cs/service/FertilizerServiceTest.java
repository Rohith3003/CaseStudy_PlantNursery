package com.cs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Fertilizer;

/**
 * This class provides basic JUnit test cases for FertilizerService class.
 * 
 * @author Rohith
 *
 */
@SpringBootTest
class FertilizerServiceTest {

	@Autowired
	IFertilizerService fertilizerService;

	@Test
	void getAllFertilizersTest() {
		List<Fertilizer> fertilizers = fertilizerService.getAllFertilizers();
		assertEquals(4, fertilizers.size());
	}

	@Test
	@Disabled
	void addFertilizer() {
		Fertilizer fertilizer = new Fertilizer();
		fertilizer.setFertilizerName("vermicompost");
		fertilizer.setFertilizerPrice(99.99);
		fertilizer.setFertilizerQuantity("5KG");
		fertilizer.setFertilizerImage("www.google.com/vermicompost");
		fertilizer.setFertilizerDescription(
				"It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.");

		// persisting object in database
		Fertilizer fertilizer1 = fertilizerService.addFertilizer(23, fertilizer);

		// verifying the result
		assertEquals("vermicompost", fertilizer1.getFertilizerName());
		assertEquals(99.99, fertilizer1.getFertilizerPrice());
		assertEquals("5KG", fertilizer1.getFertilizerQuantity());
		assertEquals("www.google.com/vermicompost", fertilizer1.getFertilizerImage());
		assertEquals(
				"It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.",
				fertilizer1.getFertilizerDescription());
	}

	@Test
	public void getFertilizerByIdTest() {
		Fertilizer fertilizer = fertilizerService.getFertilizerById(1);
		assertEquals(1, fertilizer.getFertilizerId());
		assertEquals(49.99, fertilizer.getFertilizerPrice());
		assertEquals("compost", fertilizer.getFertilizerName());
		assertEquals("www.google.com/compost", fertilizer.getFertilizerImage());
		assertEquals(
				"The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.",
				fertilizer.getFertilizerDescription());
		assertEquals("1KG", fertilizer.getFertilizerQuantity());
	}

	@Test
	@Disabled
	public void getFertilizerByNameTest() {
		Fertilizer fertilizer = fertilizerService.getFertilizerByName("vermicompost");
		assertEquals(12, fertilizer.getFertilizerId());
		assertEquals(99.99, fertilizer.getFertilizerPrice());
		assertEquals("vermicompost", fertilizer.getFertilizerName());
		assertEquals("www.google.com/vermicompost", fertilizer.getFertilizerImage());
		assertEquals(
				"It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.",
				fertilizer.getFertilizerDescription());
		assertEquals("5KG", fertilizer.getFertilizerQuantity());
	}

	@Test
	@Disabled
	public void updatePriceById() {
		Fertilizer fertilizer = fertilizerService.updatePriceById(23, 12, 89.99);
		assertEquals(12, fertilizer.getFertilizerId());
		assertEquals(89.99, fertilizer.getFertilizerPrice());
	}

	@Test
	@Disabled
	public void updatePriceByName() {
		Fertilizer fertilizer = fertilizerService.updatePriceByName(23, "plant food", 299.99);
		assertEquals("plant food", fertilizer.getFertilizerName());
		assertEquals(299.99, fertilizer.getFertilizerPrice());
	}

	@Test
	@Disabled
	public void updatePriceAndQuantityById() {
		Fertilizer fertilizer = fertilizerService.updatePriceAndQuantityById(23, 5, 549.99, "2KG");
		assertEquals("2KG", fertilizer.getFertilizerQuantity());
		assertEquals(549.99, fertilizer.getFertilizerPrice());
		assertEquals(5, fertilizer.getFertilizerId());
	}

	@Test
	@Disabled
	public void removeFertilizerByIdTest() {
		Fertilizer fertilizer = fertilizerService.getFertilizerById(11);
		Fertilizer deletedFertilizer = fertilizerService.removeFertilizerById(23, 11);
		assertEquals(fertilizer, deletedFertilizer);
	}

	@Test
	@Disabled
	public void removeFertilizerByName() {
		Fertilizer fertilizer = fertilizerService.removeFertilizerByName(23, "vermicompost");
		Fertilizer deletedFertilizer = fertilizerService.getFertilizerByName("vermicompost");
		assertEquals(fertilizer, deletedFertilizer);
	}

}
