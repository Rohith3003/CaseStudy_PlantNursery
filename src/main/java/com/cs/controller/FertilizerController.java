package com.cs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.bean.Fertilizer;
import com.cs.dto.FertilizerDto;
import com.cs.service.IFertilizerService;

/**
 * This class is used as controller to add, delete, update and retrieve
 * fertilizer to and from database
 * 
 * @author Rohith(Employee id: 46191986)
 *
 */
@RestController
public class FertilizerController {

	@Autowired
	IFertilizerService fertilizerService;

	// adds new fertilizer into database
	@PostMapping("/addFertilizer/{userId}")
	ResponseEntity<Fertilizer> addFertilizer(@PathVariable("userId") int userId,
			@Valid @RequestBody Fertilizer fertilizer) {
		return new ResponseEntity<Fertilizer>(fertilizerService.addFertilizer(userId, fertilizer), HttpStatus.OK);
	}

	// retrieves and returns the fertilizer from database based on given id.
	@GetMapping("/fertilizer/{id}")
	ResponseEntity<Fertilizer> getFertilizerById(@PathVariable("id") int id) {
		return new ResponseEntity<Fertilizer>(fertilizerService.getFertilizerById(id), HttpStatus.OK);
	}

	// retrieves and returns the fertilizer of given name.
	@GetMapping("/fertilizerByName/{name}")
	ResponseEntity<Fertilizer> getFertilizerByName(@Valid @PathVariable("name") String name) {
		return new ResponseEntity<Fertilizer>(fertilizerService.getFertilizerByName(name), HttpStatus.OK);
	}

	// retrieves the list of all available fertilizers
	@GetMapping("/allFertilizers")
	ResponseEntity<List<Fertilizer>> getAllFertilizers() {
		return new ResponseEntity<List<Fertilizer>>(fertilizerService.getAllFertilizers(), HttpStatus.OK);
	}

	// updates the price of existing fertilizer of given id
	@PutMapping("/updatePrice/{fertilizerId}/{userId}")
	ResponseEntity<Fertilizer> updatePriceById(@PathVariable("userId") int userId,
			@PathVariable("fertilizerId") int fertilizerId, @Valid @RequestBody double price) {
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceById(userId, fertilizerId, price),
				HttpStatus.OK);
	}

	// updates the price of existing fertilizer of given name
	@PutMapping("/updatePriceByName/{name}/{userId}")
	ResponseEntity<Fertilizer> updatePriceByName(@PathVariable("userId") int userId,
			@Valid @PathVariable("name") String name, @Valid @RequestBody double Price) {
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceByName(userId, name, Price), HttpStatus.OK);
	}

	// updates price and quantity of fertilizer of given id
	@PutMapping("/updatePriceAndQuantity/{fertilizerId}/{userId}")
	ResponseEntity<Fertilizer> updatePriceAndQuantityById(@PathVariable("userId") int userId,
			@PathVariable("fertilizerId") int fertilizerId, @Valid @RequestBody FertilizerDto fertilizerDto) {
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceAndQuantityById(userId, fertilizerId,
				fertilizerDto.getFertilizerPrice(), fertilizerDto.getFertilizerQuantity()), HttpStatus.OK);
	}

	// removes the fertilizer from database based on id.
	@DeleteMapping("/deleteById/{fertilizerId}/{userId}")
	ResponseEntity<Fertilizer> removeFertilizerById(@PathVariable("userId") int userId,
			@PathVariable("fertilizerId") int fertilizerId) {
		return new ResponseEntity<Fertilizer>(fertilizerService.removeFertilizerById(userId, fertilizerId),
				HttpStatus.OK);
	}

	// removes the fertilizer of given name from database
	@DeleteMapping("/deleteByName/{name}/{userId}")
	ResponseEntity<Fertilizer> deleteFertilizerByName(@PathVariable("userId") int userId,
			@Valid @PathVariable("name") String name) {
		return new ResponseEntity<Fertilizer>(fertilizerService.removeFertilizerByName(userId, name), HttpStatus.OK);
	}
}
