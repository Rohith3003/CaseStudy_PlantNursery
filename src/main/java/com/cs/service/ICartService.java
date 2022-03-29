package com.cs.service;

import com.cs.bean.Cart;
/**
 * This Interface is used to define the services provided to
 * CartController so that we can view, add to cart and remove from cart into or from database
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
public interface ICartService 
{
	Cart viewCart(int cartId);
	Cart addGardenDecorToCart(int cartId, int gardenDecorId);
	Cart removeGardenDecorFromCart(int cartId, int gardenDecorId);
	Cart addSeedToCart(int cartId, int seedId);
	Cart removeSeedFromCart(int cartId, int seedId);
	Cart addPlantToCart(int cartId, int plantId);
	Cart removePlantFromCart(int cartId, int plantId);
	Cart addFertilizerToCart(int cartId, int fertilizerId);
	Cart removeFertilizerFromCart(int cartId, int fertilizerId);
	Cart addPlanterToCart(int cartId, int planterId);
	Cart removePlanterFromCart(int cartId, int planterId);
	
}
