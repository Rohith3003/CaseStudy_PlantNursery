package com.cs.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import com.cs.bean.Cart;

@SpringBootTest
public class CartServiceTest 
{
	@Autowired
	ICartService cartServ;
	
	@Test
	@Disabled
	void viewCart()
	{
		Cart result = cartServ.viewCart(10);
		assertEquals(10,result.getCartId());
	}
	
	@Test
	@Disabled
	void addGardenDecorToCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.addGardenDecorToCart(10,5);
		assertEquals(before.getGardenDecor().size()+1,result.getGardenDecor().size());
	}
	
	@Test
	@Disabled
	void removeGardenDecorFromCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.removeGardenDecorFromCart(10,5);
		assertEquals(before.getGardenDecor().size()-1,result.getGardenDecor().size());
	}
	
	@Test
	@Disabled
	void addSeedToCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.addSeedToCart(10,5);
		assertEquals(before.getSeed().size()+1,result.getSeed().size());
	}
	
	@Test
	@Disabled
	void removeSeedFromCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.removeSeedFromCart(10,5);
		assertEquals(before.getSeed().size()-1,result.getSeed().size());
	}
	
	@Test
	@Disabled
	void addPlantToCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.addPlantToCart(10,5);
		assertEquals(before.getPlant().size()+1,result.getPlant().size());
	}
	
	@Test
	@Disabled
	void removePlantFromCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.removePlantFromCart(10,5);
		assertEquals(before.getPlant().size()-1,result.getPlant().size());
	}
	
	@Test
	@Disabled
	void addFertilizerToCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.addFertilizerToCart(10,5);
		assertEquals(before.getFertilizer().size()+1,result.getFertilizer().size());
	}
	
	@Test
	@Disabled
	void removeFertilizerFromCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.removeFertilizerFromCart(10,5);
		assertEquals(before.getFertilizer().size()-1,result.getFertilizer().size());
	}
	
	@Test
	@Disabled
	void addPlanterToCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.addPlanterToCart(10,5);
		assertEquals(before.getPlanter().size()+1,result.getPlanter().size());
	}
	
	@Test
	@Disabled
	void removePlanterFromCart()
	{
		Cart before = cartServ.viewCart(10);
		Cart result = cartServ.removePlanterFromCart(10,5);
		assertEquals(before.getPlanter().size()-1,result.getPlanter().size());
	}
}
