package com.cs.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cs.bean.Cart;
import com.cs.bean.Fertilizer;
import com.cs.bean.GardenDecor;
import com.cs.bean.Plant;
import com.cs.bean.Planter;
import com.cs.bean.Seed;
import com.cs.exception.CartException;
import com.cs.exception.FertilizerNotFoundException;
import com.cs.exception.GardenDecorException;
import com.cs.exception.PlantNotFoundException;
import com.cs.exception.PlanterNotFoundException;
import com.cs.exception.SeedNotFoundException;
import com.cs.repository.ICartRepository;
import com.cs.repository.IFertilizerRepository;
import com.cs.repository.IGardenDecorRepository;
import com.cs.repository.IPlantRepository;
import com.cs.repository.IPlanterRepository;
import com.cs.repository.ISeedRepository;
/**
 * This Class is used to define the services provided to
 * CartController so that we can view, add to cart and remove from cart into or from database
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@Service
public class CartServiceImpl implements ICartService
{
	@Autowired
	ICartRepository cartRepo;
	@Autowired
	IGardenDecorRepository gardenDecorRepo;
	@Autowired
	ISeedRepository seedRepo;
	@Autowired
	IPlantRepository plantRepo;
	@Autowired
	IPlanterRepository planterRepo;
	@Autowired
	IFertilizerRepository fertilizerRepo;
	
	/**
	 * view the cart of the given id
	 * @param cartId
	 * @return cart of given id
	 */
	@Override
	public Cart viewCart(int cartId) 
	{
		Optional<Cart> cart = cartRepo.findById(cartId);
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		return cart.get();
	}
	
	/**
	 * add gardendecor of the given id to the cart
	 * @param cartId
	 * @param gardenDecorId
	 * @return cart with the added gardendecor
	 */
	@Override
	public Cart addGardenDecorToCart(int cartId, int gardenDecorId) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(gardenDecorId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<GardenDecor> al = cart.get().getGardenDecor();
			al.add(gardenDecor.get());
			cart.get().setGardenDecor(al);
		}
		cost = cost + gardenDecor.get().getGardenDecorPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	/**
	 * remove gardendecor of the given id from the cart
	 * @param cartId
	 * @param gardenDecorId
	 * @return cart with the removed gardendecor
	 */
	@Override
	public Cart removeGardenDecorFromCart(int cartId, int gardenDecorId) 
	{
		Optional<GardenDecor> gardenDecor = gardenDecorRepo.findById(gardenDecorId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!gardenDecor.isPresent())
		{
			throw new GardenDecorException("garden decor not found with the given id:" + gardenDecorId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<GardenDecor> al = cart.get().getGardenDecor();
			al.remove(gardenDecor.get());
			cart.get().setGardenDecor(al);
		}
		cost = cost - gardenDecor.get().getGardenDecorPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	
 	/**
	 * add seed of the given id to the cart
	 * @param cartId
	 * @param seedId
	 * @return cart with the added seed
	 */
	@Override
	public Cart addSeedToCart(int cartId, int seedId) 
	{
		Optional<Seed> seed = seedRepo.findById(seedId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!seed.isPresent())
		{
			throw new SeedNotFoundException("seed not found with the given id:" + seedId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Seed> al = cart.get().getSeed();
			al.add(seed.get());
			cart.get().setSeed(al);
		}
		cost = cost + seed.get().getPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}
	
	/**
	 * remove seed of the given id from the cart
	 * @param cartId
	 * @param seedId
	 * @return cart with the removed seed
	 */
	@Override
	public Cart removeSeedFromCart(int cartId, int seedId) 
	{
		Optional<Seed> seed = seedRepo.findById(seedId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!seed.isPresent())
		{
			throw new SeedNotFoundException("seed not found with the given id:" + seedId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Seed> al = cart.get().getSeed();
			al.remove(seed.get());
			cart.get().setSeed(al);
		}
		cost = cost - seed.get().getPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	/**
	 * add plant of the given id to the cart
	 * @param cartId
	 * @param plantId
	 * @return cart with the added plant
	 */
	@Override
	public Cart addPlantToCart(int cartId, int plantId) 
	{
		Optional<Plant> plant = plantRepo.findById(plantId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!plant.isPresent())
		{
			throw new PlanterNotFoundException("plant not found with the given id:" + plantId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Plant> al = cart.get().getPlant();
			al.add(plant.get());
			cart.get().setPlant(al);
		}
		cost = cost + plant.get().getPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	/**
	 * remove plant of the given id from the cart
	 * @param cartId
	 * @param plantId
	 * @return cart with the removed plant
	 */
	@Override
	public Cart removePlantFromCart(int cartId, int plantId) 
	{
		Optional<Plant> plant = plantRepo.findById(plantId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!plant.isPresent())
		{
			throw new PlantNotFoundException("plant not found with the given id:" + plantId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Plant> al = cart.get().getPlant();
			al.remove(plant.get());
			cart.get().setPlant(al);
		}
		cost = cost - plant.get().getPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	/**
	 * add fertlizer of the given id to the cart
	 * @param cartId
	 * @param fertilizerId
	 * @return cart with the added fertilizer
	 */
	@Override
	public Cart addFertilizerToCart(int cartId, int fertilizerId) 
	{
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(fertilizerId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(fertilizer.isEmpty())
		{
			throw new FertilizerNotFoundException("fertilizer not found with the given id:" + fertilizerId);
		}
		if(cart.isEmpty())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Fertilizer> fertilizers = cart.get().getFertilizer();
			fertilizers.add(fertilizer.get());
			cart.get().setFertilizer(fertilizers);
		}
		cost = cost + fertilizer.get().getFertilizerPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	/**
	 * remove fertlizer of the given id from the cart
	 * @param cartId
	 * @param fertilizerId
	 * @return cart with the removed fertilizer
	 */
	@Override
	public Cart removeFertilizerFromCart(int cartId, int fertilizerId) 
	{
		Optional<Fertilizer> fertilizer = fertilizerRepo.findById(fertilizerId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(fertilizer.isEmpty())
		{
			throw new FertilizerNotFoundException("fertilizer not found with the given id:" + fertilizerId);
		}
		if(cart.isEmpty())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Fertilizer> fertilizers = cart.get().getFertilizer();
			fertilizers.remove(fertilizer.get());
			cart.get().setFertilizer(fertilizers);
		}
		cost = cost - fertilizer.get().getFertilizerPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	/**
	 * add planter of the given id to the cart
	 * @param cartId
	 * @param planterId
	 * @return cart with the added planter
	 */
	@Override
	public Cart addPlanterToCart(int cartId, int planterId) 
	{
		Optional<Planter> planter = planterRepo.findById(planterId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!planter.isPresent())
		{
			throw new PlanterNotFoundException("planter not found with the given id:" + planterId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Planter> al = cart.get().getPlanter();
			al.add(planter.get());
			cart.get().setPlanter(al);
		}
		cost = cost + planter.get().getPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

	/**
	 * remove planter of the given id from the cart
	 * @param cartId
	 * @param planterId
	 * @return cart with the removed planter
	 */
	@Override
	public Cart removePlanterFromCart(int cartId, int planterId) 
	{
		Optional<Planter> planter = planterRepo.findById(planterId);
		Optional<Cart> cart = cartRepo.findById(cartId);
		double cost = cart.get().getCartCost();
		if(!planter.isPresent())
		{
			throw new PlanterNotFoundException("planter not found with the given id:" + planterId);
		}
		if(!cart.isPresent())
		{
			throw new CartException("cart not found with the given id:" + cartId);
		}
		else
		{
			List<Planter> al = cart.get().getPlanter();
			al.remove(planter.get());
			cart.get().setPlanter(al);
		}
		cost = cost - planter.get().getPrice();
		cart.get().setCartCost(cost);
		cartRepo.save(cart.get());
		return cart.get();
	}

}
