package com.cs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cs.bean.Cart;
import com.cs.service.ICartService;
/**
 * This class is used for the Cart Controller to view cart, add and remove products from the cart
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@RestController
public class CartController {
	@Autowired
	ICartService cartServ;

	/**
	 * view the cart of the given id
	 * @param cartId
	 * @return cart of given id
	 */
	@GetMapping("/viewCart/{id}")
	ResponseEntity<Cart> viewCart(@PathVariable("id") int cartId) {
		Cart cart = cartServ.viewCart(cartId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * add gardendecor of the given id to the cart
	 * @param cartId
	 * @param gardenDecorId
	 * @return cart with the added gardendecor
	 */
	@PutMapping("/addGardenDecorToCart/{cartId}")
	ResponseEntity<Cart> addGardenDecorToCart(@PathVariable("cartId") int cartId, @RequestBody int gardenDecorId) {
		Cart cart = cartServ.addGardenDecorToCart(cartId, gardenDecorId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * remove gardendecor of the given id from the cart
	 * @param cartId
	 * @param gardenDecorId
	 * @return cart with the removed gardendecor
	 */
	@PutMapping("/removeGardenDecorFromCart/{cartId}")
	ResponseEntity<Cart> removeGardenDecorFromCart(@PathVariable("cartId") int cartId, @RequestBody int gardenDecorId) {
		Cart cart = cartServ.removeGardenDecorFromCart(cartId, gardenDecorId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * add seed of the given id to the cart
	 * @param cartId
	 * @param seedId
	 * @return cart with the added seed
	 */
	@PutMapping("/addSeedToCart/{cartId}")
	ResponseEntity<Cart> addSeedToCart(@PathVariable("cartId") int cartId, @RequestBody int seedId) {
		Cart cart = cartServ.addSeedToCart(cartId, seedId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * remove seed of the given id from the cart
	 * @param cartId
	 * @param seedId
	 * @return cart with the removed seed
	 */
	@PutMapping("/removeSeedFromCart/{cartId}")
	ResponseEntity<Cart> removeSeedFromCart(@PathVariable("cartId") int cartId, @RequestBody int seedId) {
		Cart cart = cartServ.removeSeedFromCart(cartId, seedId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * add plant of the given id to the cart
	 * @param cartId
	 * @param plantId
	 * @return cart with the added plant
	 */
	@PutMapping("/addPlantToCart/{cartId}")
	ResponseEntity<Cart> addPlantToCart(@PathVariable("cartId") int cartId, @RequestBody int plantId) {
		Cart cart = cartServ.addPlantToCart(cartId, plantId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * remove plant of the given id from the cart
	 * @param cartId
	 * @param plantId
	 * @return cart with the removed plant
	 */
	@PutMapping("/removePlantFromCart/{cartId}")
	ResponseEntity<Cart> removePlantFromCart(@PathVariable("cartId") int cartId, @RequestBody int plantId) {
		Cart cart = cartServ.removePlantFromCart(cartId, plantId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * add planter of the given id to the cart
	 * @param cartId
	 * @param planterId
	 * @return cart with the added planter
	 */
	@PutMapping("/addPlanterToCart/{cartId}")
	ResponseEntity<Cart> addPlanterToCart(@PathVariable("cartId") int cartId, @RequestBody int planterId) {
		Cart cart = cartServ.addPlanterToCart(cartId, planterId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * remove planter of the given id from the cart
	 * @param cartId
	 * @param planterId
	 * @return cart with the removed planter
	 */
	@PutMapping("/removePlanterFromCart/{cartId}")
	ResponseEntity<Cart> removePlanterFromCart(@PathVariable("cartId") int cartId, @RequestBody int planterId) {
		Cart cart = cartServ.removePlanterFromCart(cartId, planterId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * add fertlizer of the given id to the cart
	 * @param cartId
	 * @param fertilizerId
	 * @return cart with the added fertilizer
	 */
	@PutMapping("/addFertilizerToCart/{cartId}")
	ResponseEntity<Cart> addFertilizerToCart(@PathVariable("cartId") int cartId, @RequestBody int fertilizerId) {
		Cart cart = cartServ.addFertilizerToCart(cartId, fertilizerId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/**
	 * remove fertlizer of the given id from the cart
	 * @param cartId
	 * @param fertilizerId
	 * @return cart with the removed fertilizer
	 */
	@PutMapping("/removeFertlizerFromCart/{cartId}")
	ResponseEntity<Cart> removeFertilizerFromCart(@PathVariable("cartId") int cartId, @RequestBody int fertilizerId) {
		Cart cart = cartServ.removeFertilizerFromCart(cartId, fertilizerId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

}
