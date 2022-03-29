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
import com.cs.bean.GardenDecor;
import com.cs.service.IGardenDecorService;
/**
 * This class is used as controller to add, delete, update and retrieve gardendecor to and from database
 * @author Mayank Kumar(Employee ID: 46191925)
 *
 */
@RestController
public class GardenDecorController 
{
	@Autowired
	IGardenDecorService gardenDecorServ;
	
	/**
	 * Adds new gardendecor to the database.
	 * @param id
	 * @param gardenDecor
	 * @return eturns the gardendecor object which is persisted in database.
	 */
	@PostMapping("/addGardenDecor/{id}")
	ResponseEntity<GardenDecor> addGardenDecor(@Valid @PathVariable("id") int id, @RequestBody GardenDecor gardenDecor) 
	{
		GardenDecor gd =  gardenDecorServ.addGardenDecor(id,gardenDecor);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
	
	/**
	 * Retrieves the gardendecor of given id from database.
	 * @param gardenDecorId
	 * @return Returns the gardendecor of given id.
	 */
	@GetMapping("/getGardenDecorById/{id}")
	ResponseEntity<GardenDecor> getTraineeById(@PathVariable("id") int gardenDecorId) 
	{
		GardenDecor gardenDecor = gardenDecorServ.getGardenDecorById(gardenDecorId);
		return new ResponseEntity<>(gardenDecor, HttpStatus.OK);
	}
	
	/**
	 * Retrieves the list of all available gardendecor from database.
	 * @return Returns the list of gardendecor.
	 */
	@GetMapping("/getAllGardenDecor/{id}")
	List<GardenDecor> getAllGardenDecor() 
	{
		return gardenDecorServ.getAllGardenDecor();
	}
	
	/**
	 * Updates the name of existing gardendecor of given id.
	 * @param id
	 * @param gardenDecorId
	 * @param gardenDecorName
	 * @return Returns the updated gardendecor object from database.
	 */
	@PutMapping("/updateGardenDecorNameById/{id}")
	ResponseEntity<GardenDecor> updateGardenDecorNameById(@Valid @PathVariable("id") int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorName) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorNameById(id,gardenDecorId,gardenDecorName);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	/**
	 * Updates the price of existing gardendecor of given id.
	 * @param id
	 * @param gardenDecorId
	 * @param gardenDecorPrice
	 * @return Returns the updated gardendecor object from database.
	 */
	@PutMapping("/updateGardenDecorPriceById/{id}")
	ResponseEntity<GardenDecor> updateGardenDecorPriceById(@Valid @PathVariable("id") int id, @RequestBody int gardenDecorId, @RequestBody float gardenDecorPrice) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorPriceById(id,gardenDecorId,gardenDecorPrice);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	/**
	 * Updates the image of existing gardendecor of given id.
	 * @param id
	 * @param gardenDecorId
	 * @param gardenDecorImage
	 * @return Returns the updated gardendecor object from database.
	 */
	@PutMapping("/updateGardenDecorImageById/{id}")
	ResponseEntity<GardenDecor> updateGardenDecorImageById(@Valid @PathVariable("id") int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorImage) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorImageById(id,gardenDecorId,gardenDecorImage);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	/**
	 * Updates the description of existing gardendecor of given id.
	 * @param id
	 * @param gardenDecorId
	 * @param gardenDecorDescription
	 * @return Returns the updated gardendecor object from database.
	 */
	@PutMapping("/updateGardenDecorDescriptionById/{id}")
	ResponseEntity<GardenDecor> updateGardenDecorDescriptionById(@Valid @PathVariable("id") int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorDescription) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorDescriptionById(id,gardenDecorId,gardenDecorDescription);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	/**
	 * Deletes the gardendecor of given id from database.
	 * @param id
	 * @param gardenDecorId
	 * @return Returns the deleted gardendecor.
	 */
	@DeleteMapping("/deleteGardenDecorById/{id}")
	ResponseEntity<GardenDecor> updateGardenDecorById(@PathVariable("id") int id, @RequestBody int gardenDecorId) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.deleteGardenDecorById(id,gardenDecorId);
		return new ResponseEntity<>(gardenDecor, HttpStatus.OK);
	}
}
