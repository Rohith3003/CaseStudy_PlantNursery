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

	/**
	 * Adds new fertilizer to the database.
	 * 
	 * @param userId
	 * @param fertilizer
	 * @return Returns the fertilizer object which is persisted in database.
	 */
	@PostMapping("/addFertilizer/{userId}")
	ResponseEntity<Fertilizer> addFertilizer(@PathVariable("userId") int userId,
			@Valid @RequestBody Fertilizer fertilizer) {
		return new ResponseEntity<Fertilizer>(fertilizerService.addFertilizer(userId, fertilizer), HttpStatus.OK);
	}

	/**
	 * Retrieves the fertilizer of given id from database.
	 * 
	 * @param id
	 * @return Returns the fertilizer of given id.
	 */
	@GetMapping("/fertilizer/{id}")
	ResponseEntity<Fertilizer> getFertilizerById(@PathVariable("id") int id) {
		return new ResponseEntity<Fertilizer>(fertilizerService.getFertilizerById(id), HttpStatus.OK);
	}

	/**
	 * Retrieves the fertilizer of given name from database.
	 * 
	 * @param name
	 * @return Returns the fertilizer of given name.
	 */
	@GetMapping("/fertilizerByName/{name}")
	ResponseEntity<Fertilizer> getFertilizerByName(@Valid @PathVariable("name") String name) {
		return new ResponseEntity<Fertilizer>(fertilizerService.getFertilizerByName(name), HttpStatus.OK);
	}

	/**
	 * Retrieves the list of all available fertilizers from database.
	 * 
	 * @return Returns the list of fertilizers.
	 */
	@GetMapping("/allFertilizers")
	ResponseEntity<List<Fertilizer>> getAllFertilizers() {
		return new ResponseEntity<List<Fertilizer>>(fertilizerService.getAllFertilizers(), HttpStatus.OK);
	}

	/**
	 * Updates the price of existing fertilizer of given id.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @param price
	 * @return Returns the updated fertilizer object from database.
	 */
	@PutMapping("/updatePrice/{fertilizerId}/{userId}")
	ResponseEntity<Fertilizer> updatePriceById(@PathVariable("userId") int userId,
			@PathVariable("fertilizerId") int fertilizerId, @Valid @RequestBody double price) {
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceById(userId, fertilizerId, price),
				HttpStatus.OK);
	}

	/**
	 * Updates the price of existing fertilizer of given name.
	 * 
	 * @param userId
	 * @param name
	 * @param Price
	 * @return Returns the updated fertilizer object from database.
	 */
	@PutMapping("/updatePriceByName/{name}/{userId}")
	ResponseEntity<Fertilizer> updatePriceByName(@PathVariable("userId") int userId,
			@Valid @PathVariable("name") String name, @Valid @RequestBody double Price) {
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceByName(userId, name, Price), HttpStatus.OK);
	}

	/**
	 * Updates price and quantity of fertilizer of given id.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @param fertilizerDto
	 * @return Returns the updated fertilizer object from database.
	 */
	@PutMapping("/updatePriceAndQuantity/{fertilizerId}/{userId}")
	ResponseEntity<Fertilizer> updatePriceAndQuantityById(@PathVariable("userId") int userId,
			@PathVariable("fertilizerId") int fertilizerId, @Valid @RequestBody FertilizerDto fertilizerDto) {
		return new ResponseEntity<Fertilizer>(fertilizerService.updatePriceAndQuantityById(userId, fertilizerId,
				fertilizerDto.getFertilizerPrice(), fertilizerDto.getFertilizerQuantity()), HttpStatus.OK);
	}

	/**
	 * Deletes the fertilizer of given id from database.
	 * 
	 * @param userId
	 * @param fertilizerId
	 * @return Returns the deleted fertilizer.
	 */
	@DeleteMapping("/deleteById/{fertilizerId}/{userId}")
	ResponseEntity<Fertilizer> removeFertilizerById(@PathVariable("userId") int userId,
			@PathVariable("fertilizerId") int fertilizerId) {
		return new ResponseEntity<Fertilizer>(fertilizerService.removeFertilizerById(userId, fertilizerId),
				HttpStatus.OK);
	}

	/**
	 * Deletes the fertilizer of given name from database.
	 * 
	 * @param userId
	 * @param name
	 * @return Returns the deleted fertilizer.
	 */
	@DeleteMapping("/deleteByName/{name}/{userId}")
	ResponseEntity<Fertilizer> deleteFertilizerByName(@PathVariable("userId") int userId,
			@Valid @PathVariable("name") String name) {
		return new ResponseEntity<Fertilizer>(fertilizerService.removeFertilizerByName(userId, name), HttpStatus.OK);
	}
}
