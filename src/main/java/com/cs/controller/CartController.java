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

@RestController
public class CartController {
	@Autowired
	ICartService cartServ;

	@GetMapping("/viewCart/{id}")
	ResponseEntity<Cart> viewCart(@PathVariable("id") int cartId) {
		Cart cart = cartServ.viewCart(cartId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@PutMapping("/addGardenDecorToCart/{cartId}")
	ResponseEntity<Cart> addGardenDecorToCart(@PathVariable("cartId") int cartId, @RequestBody int gardenDecorId) {
		Cart cart = cartServ.addGardenDecorToCart(cartId, gardenDecorId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	@PutMapping("/removeGardenDecorFromCart/{cartId}")
	ResponseEntity<Cart> removeGardenDecorFromCart(@PathVariable("cartId") int cartId, @RequestBody int gardenDecorId) {
		Cart cart = cartServ.removeGardenDecorFromCart(cartId, gardenDecorId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// add seed to cart

	@PutMapping("/addSeedToCart/{cartId}")
	ResponseEntity<Cart> addSeedToCart(@PathVariable("cartId") int cartId, @RequestBody int seedId) {
		Cart cart = cartServ.addSeedToCart(cartId, seedId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// remove seed from cart

	@PutMapping("/removeSeedFromCart/{cartId}")
	ResponseEntity<Cart> removeSeedFromCart(@PathVariable("cartId") int cartId, @RequestBody int seedId) {
		Cart cart = cartServ.removeSeedFromCart(cartId, seedId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// add plant to cart

	@PutMapping("/addPlantToCart/{cartId}")
	ResponseEntity<Cart> addPlantToCart(@PathVariable("cartId") int cartId, @RequestBody int plantId) {
		Cart cart = cartServ.addPlantToCart(cartId, plantId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// remove plant from cart

	@PutMapping("/removePlantFromCart/{cartId}")
	ResponseEntity<Cart> removePlantFromCart(@PathVariable("cartId") int cartId, @RequestBody int plantId) {
		Cart cart = cartServ.removePlantFromCart(cartId, plantId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// add planter to cart

	@PutMapping("/addPlanterToCart/{cartId}")
	ResponseEntity<Cart> addPlanterToCart(@PathVariable("cartId") int cartId, @RequestBody int planterId) {
		Cart cart = cartServ.addPlanterToCart(cartId, planterId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// remove planter from cart

	@PutMapping("/removePlanterFromCart/{cartId}")
	ResponseEntity<Cart> removePlanterFromCart(@PathVariable("cartId") int cartId, @RequestBody int planterId) {
		Cart cart = cartServ.removePlanterFromCart(cartId, planterId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// add fertilizer to cart
	@PutMapping("/addFertilizerToCart/{cartId}")
	ResponseEntity<Cart> addFertilizerToCart(@PathVariable("cartId") int cartId, @RequestBody int fertilizerId) {
		Cart cart = cartServ.addFertilizerToCart(cartId, fertilizerId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	// remove fertilizer from cart
	@PutMapping("/removeFertlizerFromCart/{cartId}")
	ResponseEntity<Cart> removeFertilizerFromCart(@PathVariable("cartId") int cartId, @RequestBody int fertilizerId) {
		Cart cart = cartServ.removeFertilizerFromCart(cartId, fertilizerId);
		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

}
