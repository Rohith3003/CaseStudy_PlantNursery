package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
import com.cs.bean.Cart;
import com.cs.bean.Fertilizer;
import com.cs.bean.GardenDecor;
import com.cs.bean.Plant;
import com.cs.bean.Planter;
import com.cs.bean.Seed;
import com.cs.repository.ICartRepository;
import com.cs.repository.IFertilizerRepository;
import com.cs.repository.IGardenDecorRepository;
import com.cs.repository.IPlantRepository;
import com.cs.repository.IPlanterRepository;
import com.cs.repository.ISeedRepository;

/**
 * This class provides Mockito test cases for CartService.
 * 
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@ExtendWith(SpringExtension.class)
public class CartServiceMockitoTest {
	@InjectMocks
	CartServiceImpl cartServ;

	@MockBean
	ICartRepository cartRepo;
	@MockBean
	IPlanterRepository planterRepo;
	@MockBean
	IFertilizerRepository fertilizerRepo;
	@MockBean
	ISeedRepository seedRepo;
	@MockBean
	IPlantRepository plantRepo;
	@MockBean
	IGardenDecorRepository gardenDecorRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void viewCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Fertilizer fertilizer = new Fertilizer();
		Seed seed = new Seed();
		Plant plant = new Plant();
		Planter planter = new Planter();
		GardenDecor gardenDecor = new GardenDecor();
		gardenDecorList.add(gardenDecor);
		seedList.add(seed);
		plantList.add(plant);
		planterList.add(planter);
		fertilizerList.add(fertilizer);
		Cart cart = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart));
		Cart result = cartServ.viewCart(1);
		assertEquals(1, result.getCartId());
	}

	@Test
	void addGardenDecorToCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		GardenDecor gardenDecor = new GardenDecor();
		gardenDecor.setGardenDecorId(2);
		gardenDecorList.add(gardenDecor);
		cart1.setGardenDecor(gardenDecorList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(gardenDecorRepo.findById(2)).thenReturn(Optional.of(gardenDecor));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.addGardenDecorToCart(1, 2);
		assertEquals(cart1.getGardenDecor().size(), result.getGardenDecor().size());
	}

	@Test
	void removeGardenDecorFromCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		GardenDecor gardenDecor = new GardenDecor();
		gardenDecorList.add(gardenDecor);
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		gardenDecorList.remove(gardenDecor);
		cart1.setGardenDecor(gardenDecorList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(gardenDecorRepo.findById(2)).thenReturn(Optional.of(gardenDecor));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.removeGardenDecorFromCart(1, 2);
		assertEquals(cart1.getGardenDecor().size(), result.getGardenDecor().size());
	}

	@Test
	void addSeedToCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		Seed seed = new Seed();
		seed.setSeedId(2);
		seedList.add(seed);
		cart1.setSeed(seedList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(seedRepo.findById(2)).thenReturn(Optional.of(seed));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.addSeedToCart(1, 2);
		assertEquals(cart1.getSeed().size(), result.getSeed().size());

	}

	@Test
	void removeSeedFromCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Seed seed = new Seed();
		seedList.add(seed);
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		seedList.remove(seed);
		cart1.setSeed(seedList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(seedRepo.findById(2)).thenReturn(Optional.of(seed));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.removeSeedFromCart(1, 2);
		assertEquals(cart1.getSeed().size(), result.getSeed().size());
	}

	@Test
	void addPlantToCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		Plant plant = new Plant();
		plant.setPlantId(2);
		plantList.add(plant);
		cart1.setPlant(plantList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(plantRepo.findById(2)).thenReturn(Optional.of(plant));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.addPlantToCart(1, 2);
		assertEquals(cart1.getPlant().size(), result.getPlant().size());

	}

	@Test
	void removePlantFromCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Plant plant = new Plant();
		plant.setPlantId(2);
		plantList.add(plant);
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		plantList.remove(plant);
		cart1.setPlant(plantList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(plantRepo.findById(2)).thenReturn(Optional.of(plant));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.removePlantFromCart(1, 2);
		assertEquals(cart1.getPlant().size(), result.getPlant().size());

	}

	@Test
	void addFertilizerToCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		Fertilizer fertilizer = new Fertilizer();
		fertilizer.setFertilizerId(2);
		fertilizerList.add(fertilizer);
		cart1.setFertilizer(fertilizerList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(fertilizerRepo.findById(2)).thenReturn(Optional.of(fertilizer));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.addFertilizerToCart(1, 2);
		assertEquals(cart1.getFertilizer().size(), result.getFertilizer().size());

	}

	@Test
	void removeFertilizerFromCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Fertilizer fertilizer = new Fertilizer();
		fertilizer.setFertilizerId(2);
		fertilizerList.add(fertilizer);
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		fertilizerList.remove(fertilizer);
		cart1.setFertilizer(fertilizerList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(fertilizerRepo.findById(2)).thenReturn(Optional.of(fertilizer));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.removeFertilizerFromCart(1, 2);
		assertEquals(cart1.getFertilizer().size(), result.getFertilizer().size());
	}

	@Test
	void addPlanterToCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		Planter planter = new Planter();
		planter.setPlanterId(2);
		planterList.add(planter);
		cart1.setPlanter(planterList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(planterRepo.findById(2)).thenReturn(Optional.of(planter));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.addPlanterToCart(1, 2);
		assertEquals(cart1.getPlanter().size(), result.getPlanter().size());

	}

	@Test
	void removePlanterFromCart() {
		List<GardenDecor> gardenDecorList = new ArrayList<GardenDecor>();
		List<Seed> seedList = new ArrayList<Seed>();
		List<Plant> plantList = new ArrayList<Plant>();
		List<Planter> planterList = new ArrayList<Planter>();
		List<Fertilizer> fertilizerList = new ArrayList<Fertilizer>();
		Planter planter = new Planter();
		planter.setPlanterId(2);
		planterList.add(planter);
		Cart cart1 = new Cart(1, 0, gardenDecorList, seedList, plantList, planterList, fertilizerList);
		planterList.remove(planter);
		cart1.setPlanter(planterList);
		Mockito.when(cartRepo.findById(1)).thenReturn(Optional.of(cart1));
		Mockito.when(planterRepo.findById(2)).thenReturn(Optional.of(planter));
		Mockito.when(cartRepo.save(cart1)).thenReturn(cart1);
		Cart result = cartServ.removePlanterFromCart(1, 2);
		assertEquals(cart1.getPlanter().size(), result.getPlanter().size());
	}
}
