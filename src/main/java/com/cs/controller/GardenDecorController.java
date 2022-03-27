package com.cs.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cs.bean.GardenDecor;
import com.cs.service.IGardenDecorService;

@RestController
public class GardenDecorController 
{
	@Autowired
	IGardenDecorService gardenDecorServ;
	
	// add garden decor
	@PostMapping("/addGardenDecor")
	ResponseEntity<GardenDecor> addGardenDecor(@Valid @RequestBody int id, @RequestBody GardenDecor gardenDecor) 
	{
		GardenDecor gd =  gardenDecorServ.addGardenDecor(id,gardenDecor);
		return new ResponseEntity<>(gd, HttpStatus.CREATED);
	}
	
	// get garden decor based on id
	@GetMapping("/getGardenDecorById")
	ResponseEntity<GardenDecor> getTraineeById(@RequestBody int gardenDecorId) 
	{
		GardenDecor gardenDecor = gardenDecorServ.getGardenDecorById(gardenDecorId);
		return new ResponseEntity<>(gardenDecor, HttpStatus.OK);
	}
	
	// get all garden decor
	@GetMapping("/getAllGardenDecor")
	List<GardenDecor> getAllGardenDecor() 
	{
		return gardenDecorServ.getAllGardenDecor();
	}
	
	// update garden decor name based on id
	@PutMapping("/updateGardenDecorNameById")
	ResponseEntity<GardenDecor> updateGardenDecorNameById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorName) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorNameById(id,gardenDecorId,gardenDecorName);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	// update garden decor price based on id
	@PutMapping("/updateGardenDecorPriceById")
	ResponseEntity<GardenDecor> updateGardenDecorPriceById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody float gardenDecorPrice) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorPriceById(id,gardenDecorId,gardenDecorPrice);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	// update garden decor image based on id
	@PutMapping("/updateGardenDecorImageById")
	ResponseEntity<GardenDecor> updateGardenDecorImageById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorImage) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorImageById(id,gardenDecorId,gardenDecorImage);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	// update garden decor description based on id
	@PutMapping("/updateGardenDecorDescriptionById")
	ResponseEntity<GardenDecor> updateGardenDecorDescriptionById(@Valid @RequestBody int id, @RequestBody int gardenDecorId, @RequestBody String gardenDecorDescription) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.updateGardenDecorDescriptionById(id,gardenDecorId,gardenDecorDescription);
		return new ResponseEntity<>(gardenDecor, HttpStatus.CREATED);
	}
	
	// delete garden decor based on id
	@DeleteMapping("/deleteGardenDecorById")
	ResponseEntity<GardenDecor> updateGardenDecorById(@RequestBody int id, @RequestBody int gardenDecorId) 
	{
		GardenDecor gardenDecor =  gardenDecorServ.deleteGardenDecorById(id,gardenDecorId);
		return new ResponseEntity<>(gardenDecor, HttpStatus.OK);
	}
}
