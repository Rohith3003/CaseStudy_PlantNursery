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

	
	/**
	 * JUnit test case which tests the get all fertilizers functionality of
	 * FertilizerService class.
	 */
	@Test
	void getAllFertilizersTest() {
		List<Fertilizer> fertilizers = fertilizerService.getAllFertilizers();
		assertEquals(4, fertilizers.size());
	}

	/**
	 * JUnit test case which tests the add fertilizer functionality of
	 * FertilizerService class.
	 */
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

	/**
	 * JUnit test case that tests the get fertilizer by id functionality of
	 * FertilizerService.
	 */
	@Test
	public void getFertilizerByIdTest() {
		Fertilizer fertilizer = fertilizerService.getFertilizerById(5);
		assertEquals(5, fertilizer.getFertilizerId());
		assertEquals(20, fertilizer.getFertilizerPrice());
		assertEquals("compost", fertilizer.getFertilizerName());
		assertEquals("https://www.compostImage.jpg", fertilizer.getFertilizerImage());
		assertEquals(
				"The process involves decomposing organic material into a humus-like material, known as compost, which is a good fertilizer for plants.",
				fertilizer.getFertilizerDescription());
		assertEquals("1KG", fertilizer.getFertilizerQuantity());
	}

	/**
	 * JUnit test case that tests the get fertilizer by name functionality of
	 * FertilizerService.
	 */
	@Test
	public void getFertilizerByNameTest() {
		Fertilizer fertilizer = fertilizerService.getFertilizerByName("Vermicompost");
		assertEquals(8, fertilizer.getFertilizerId());
		assertEquals(39.99, fertilizer.getFertilizerPrice());
		assertEquals("Vermicompost", fertilizer.getFertilizerName());
		assertEquals("https://wwww.Vermicompost.jpg", fertilizer.getFertilizerImage());
		assertEquals(
				"It is manure obtained from the disintegration of organic waste by earthworms. Vermicompost is moist, dark, consistent manure with a slow & steady supply of nutrients.",
				fertilizer.getFertilizerDescription());
		assertEquals("1KG", fertilizer.getFertilizerQuantity());
	}

	/**
	 * JUnit test case that tests the update fertilizer price by id functionality of
	 * FertilizerService.
	 */
	@Test
	public void updatePriceById() {
		Fertilizer fertilizer = fertilizerService.updatePriceById(1, 8, 89.99);
		assertEquals(8, fertilizer.getFertilizerId());
		assertEquals(89.99, fertilizer.getFertilizerPrice());
	}

	/**
	 * JUnit test case that tests the update fertilizer price by name functionality
	 * of FertilizerService.
	 */
	@Test
	@Disabled
	public void updatePriceByName() {
		Fertilizer fertilizer = fertilizerService.updatePriceByName(23, "plant food", 299.99);
		assertEquals("plant food", fertilizer.getFertilizerName());
		assertEquals(299.99, fertilizer.getFertilizerPrice());
	}

	/**
	 * JUnit test case that tests the update price and quantity of fertilizer by id
	 * functionality of FertilizerService.
	 */
	@Test
	@Disabled
	public void updatePriceAndQuantityById() {
		Fertilizer fertilizer = fertilizerService.updatePriceAndQuantityById(23, 5, 549.99, "2KG");
		assertEquals("2KG", fertilizer.getFertilizerQuantity());
		assertEquals(549.99, fertilizer.getFertilizerPrice());
		assertEquals(5, fertilizer.getFertilizerId());
	}

	/**
	 * JUnit test case that tests the remove fertilizer by id functionality of
	 * FertilizerService.
	 */
	@Test
	@Disabled
	public void removeFertilizerByIdTest() {
		Fertilizer fertilizer = fertilizerService.getFertilizerById(11);
		Fertilizer deletedFertilizer = fertilizerService.removeFertilizerById(23, 11);
		assertEquals(fertilizer, deletedFertilizer);
	}

	/**
	 * JUnit test case that tests the remove fertilizer by name functionality of
	 * FertilizerService.
	 */
	@Test
	@Disabled
	public void removeFertilizerByName() {
		Fertilizer fertilizer = fertilizerService.removeFertilizerByName(23, "vermicompost");
		Fertilizer deletedFertilizer = fertilizerService.getFertilizerByName("vermicompost");
		assertEquals(fertilizer, deletedFertilizer);
	}

}
