package com.cs.controller;

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

import com.cs.bean.Plant;
import com.cs.service.IPlantService;

@RestController
public class PlantController {
	@Autowired
	IPlantService plantService;
	
	@PostMapping("/addPlant")
	public ResponseEntity<Plant> addSeed(@Valid @RequestBody Plant plant)
	{
		return new ResponseEntity<Plant>(plantService.addPlant(plant),HttpStatus.OK);
	}
	
	@GetMapping("/getPlant/{id}")
	public ResponseEntity<Plant> getById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Plant>(plantService.getPlantById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getPlantByName/{name}")
	public ResponseEntity<Plant> getByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Plant>(plantService.getPlantByName(name),HttpStatus.OK);
	}
	
	@PatchMapping("/updatePlantPrice/{id}")
	public ResponseEntity<Plant> updatePrice(@RequestBody float price, @PathVariable("id") int id)
	{
		return new ResponseEntity<Plant>(plantService.updatePlantPrice(id, price),HttpStatus.OK);
	}
	
	@DeleteMapping("deletePlant/{id}")
	public ResponseEntity<Plant> deleteById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Plant>(plantService.deletePlantById(id),HttpStatus.OK);
	}
}
