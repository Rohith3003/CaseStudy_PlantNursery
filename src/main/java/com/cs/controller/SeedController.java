package com.cs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cs.bean.Seed;
import com.cs.service.ISeedService;

/**
 * Controller class for Seed entity containing CRUD operations 
 * and additional custom operations that reflects the database
 * @author Palak
 *
 */


@RestController
public class SeedController {
	@Autowired
	//bean mapping
	ISeedService seedService;
	/**
	 * To add Seed record to DB
	 * @param Seed
	 * @param userId
	 * @return ResponseEntity(Seed)
	 */
	@PostMapping("/addSeed")
	public ResponseEntity<Seed> addSeed(@Valid @RequestBody Seed seed, int userId)
	{
		Seed s= seedService.addSeed(seed, userId);
		return new ResponseEntity<>(s,HttpStatus.CREATED);
	}
	/**
	 * Fetch the Seed record based on id
	 * @param id
	 * @return ResponseEntity(Seed)
	 */
	@GetMapping("/getSeed/{id}")
	public ResponseEntity<Seed> getById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Seed>(seedService.getSeedById(id),HttpStatus.OK);
	}
	/**
	 * Fetch the Seed record based on Seed name
	 * @param name
	 * @return ResponseEntity(Seed)
	 */
	@GetMapping("/getSeedByName/{name}")
	public ResponseEntity<Seed> getByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Seed>(seedService.getSeedByName(name),HttpStatus.OK);
	}
	
	/**
	 * Fetches all the Seed records from DB.
	 * @param id
	 * @return ResponseEntity(List(Seed))
	 */
	@GetMapping("/getAllSeeds")
	public ResponseEntity<List<Seed>> getAllSeeds()
	{
		return new ResponseEntity<List<Seed>>(seedService.getAllSeeds(),HttpStatus.OK);
	}
	
	/**
	 * Update the Seed price based on id
	 * @param price
	 * @param id
	 * @param userId
	 * @return ResponseEntity(Seed)
	 */
	@PatchMapping("/updatePrice/{id}/{userId}")
	public ResponseEntity<Seed> updatePrice(@RequestBody double price, @PathVariable("id") int id, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<Seed>(seedService.updateSeedPrice(id, price, userId),HttpStatus.OK);
	}
	
	/**
	 * Update the Seed photo based on id
	 * @param photoLoc
	 * @param id
	 * @param userId
	 * @return ResponseEntity(Seed)
	 */
	@PatchMapping("/updateSeedPhoto/{id}/{userId}")
	public ResponseEntity<Seed> updatePhoto(@RequestBody String photoLoc,@PathVariable("id") int id, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<Seed>(seedService.updateSeedPhoto( id,photoLoc, userId),HttpStatus.OK);
	}
	
	/**
	 * Delete Seed based on id
	 * @param id
	 * @param userId
	 * @return ResponseEntity(Seed)
	 */
	@DeleteMapping("/deleteSeed/{id}/{userId}")
	ResponseEntity<Seed> deleteSeed(@PathVariable("id") int id,@PathVariable("userId") int userId) {
		Seed deleteSeed = seedService.deleteSeedById(id,userId);
		return new ResponseEntity<>(deleteSeed, HttpStatus.OK); // 200 Ok
	}
}
