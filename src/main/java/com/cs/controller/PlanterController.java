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

import com.cs.bean.Planter;
import com.cs.service.IPlanterService;

/**
 * Controller class for Planter entity containing CRUD operations 
 * and additional custom operations that reflects the database
 * @author Hemanth
 *
 */

@RestController
public class PlanterController {
	
	@Autowired
	IPlanterService planterservice;
	
	@PostMapping("/addPlanter")
	public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter)
	{
		return new ResponseEntity<Planter>(planterservice.addPlanter(planter),HttpStatus.OK);
	}
	
	@GetMapping("/getPlanter/{id}")
	public ResponseEntity<Planter> getById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.getPlanterById(id),HttpStatus.OK);
	}
	
	@GetMapping("/getAllPlanters")
	public ResponseEntity<List<Planter>> getAllPlanters()
	{
		return new ResponseEntity<List<Planter>>(planterservice.getAllPlanters(),HttpStatus.OK);
	}
	
	@GetMapping("/getPlanterByName/{name}")
	public ResponseEntity<Planter> getByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Planter>(planterservice.getPlanterByName(name),HttpStatus.OK);
	}
	
	@PatchMapping("/updatePlanterPriceById/{id}")
	public ResponseEntity<Planter> updatePrice(@RequestBody float price, @PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.updatePlanterPrice(id, price),HttpStatus.OK);
	}
	
	@PatchMapping("/updatePlanterPriceByName/{name}")
	public ResponseEntity<Planter> updatePrice(@RequestBody float price,@PathVariable("name")String name)
	{
		return new ResponseEntity<Planter>(planterservice.updatePlanterPrice(name, price),HttpStatus.OK);
	}
	
	@PatchMapping("/updatePlanterPhoto/{id}")
	public ResponseEntity<Planter> updatePhoto(@RequestBody String photoLoc,@PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.updatePlanterPhoto(id, photoLoc),HttpStatus.OK);
	}
	@DeleteMapping("deletePlanterById/{id}")
	public ResponseEntity<Planter> deleteById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.deletePlanterById(id),HttpStatus.OK);
	}
	
	@DeleteMapping("deletePlanterByName/{name}")
	public ResponseEntity<Planter> deleteByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<>(planterservice.deletePlanterByName(name),HttpStatus.OK);
	}
}
