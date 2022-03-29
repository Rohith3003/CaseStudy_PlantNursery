package com.cs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import com.cs.dto.PlanterDto;
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
	
	/**
	 * To add Planter record to DB
	 * @param planter
	 * @param userId
	 * @return ResponseEntity(Planter)
	 */
	@PostMapping("/addPlanter/{userId}")
	public ResponseEntity<Planter> addPlanter(@Valid @RequestBody Planter planter, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<Planter>(planterservice.addPlanter(planter,userId),HttpStatus.OK);
	}
	
	/**
	 * Fetch the planter record based on id
	 * @param id
	 * @return ResponseEntity(Planter)
	 */
	@GetMapping("/getPlanter/{id}")
	public ResponseEntity<Planter> getById(@PathVariable("id") int id)
	{
		return new ResponseEntity<Planter>(planterservice.getPlanterById(id),HttpStatus.OK);
	}
	
	/**
	 * Fetches all the planter records from DB.
	 * @param id
	 * @return ResponseEntity(List(Planter))
	 */
	@GetMapping("/getAllPlanters")
	public ResponseEntity<List<PlanterDto>> getAllPlanters()
	{
		return new ResponseEntity<List<PlanterDto>>(planterservice.getAllPlanters(),HttpStatus.OK);
	}
	
	/**
	 * Fetch the planter record based on planter name
	 * @param name
	 * @return ResponseEntity(Planter)
	 */
	@GetMapping("/getPlanterByName/{name}")
	public ResponseEntity<Planter> getByName(@PathVariable("name") String name)
	{
		return new ResponseEntity<Planter>(planterservice.getPlanterByName(name),HttpStatus.OK);
	}
	
	/**
	 * Update the planter price based on id
	 * @param price
	 * @param id
	 * @param userId
	 * @return ResponseEntity(Planter)
	 */
	@PatchMapping("/updatePlanterPriceById/{id}/{userId}")
	public ResponseEntity<Planter> updatePrice(@RequestBody float price, @PathVariable("id") int id, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<Planter>(planterservice.updatePlanterPrice(id, price,userId),HttpStatus.OK);
	}
	
	/**
	 * Update the planter price based on name
	 * @param price
	 * @param name
	 * @param userId
	 * @return ResponseEntity(Planter)
	 */
	@PatchMapping("/updatePlanterPriceByName/{name}/{userId}")
	public ResponseEntity<Planter> updatePrice(@RequestBody float price,@PathVariable("name")String name, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<Planter>(planterservice.updatePlanterPrice(name, price,userId),HttpStatus.OK);
	}
	
	/**
	 * Update the planter photo based on id
	 * @param photoLoc
	 * @param id
	 * @param userId
	 * @return ResponseEntity(Planter)
	 */
	@PatchMapping("/updatePlanterPhoto/{id}/{userId}")
	public ResponseEntity<Planter> updatePhoto(@RequestBody String photoLoc,@PathVariable("id") int id, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<Planter>(planterservice.updatePlanterPhoto(id, photoLoc,userId),HttpStatus.OK);
	}
	
	/**
	 * Delete planter based on id
	 * @param id
	 * @param userId
	 * @return ResponseEntity(Planter)
	 */
	@DeleteMapping("deletePlanterById/{id}/{userId}")
	public ResponseEntity<Planter> deleteById(@PathVariable("id") int id, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<Planter>(planterservice.deletePlanterById(id,userId),HttpStatus.OK);
	}
	
	/**
	 * Delete planter based on name
	 * @param id
	 * @param userId
	 * @return ResponseEntity(Planter)
	 */
	@DeleteMapping("deletePlanterByName/{name}/{userId}")
	public ResponseEntity<Planter> deleteByName(@PathVariable("name") String name, @PathVariable("userId") int userId)
	{
		return new ResponseEntity<>(planterservice.deletePlanterByName(name,userId),HttpStatus.OK);
	}
	
	/**
	 * Get all the planters ordered by specific customer
	 * @param custId
	 * @return ResponseEntity(List(Planter))
	 */
	@GetMapping("/getPlantersByCustomer/{custId}")
	public ResponseEntity<List<PlanterDto>> getAllByCustomerId(@PathVariable("custId") int custId)
	{
		return new ResponseEntity<>(planterservice.getPlantersByCustomerId(custId),HttpStatus.OK);
	}
	
	/**
	 * Get all planter records in sorted order of specific field
	 * @param field
	 * @return ResponseEntity(List(PlanterDto))
	 */
	@GetMapping("/getAllInSortedBy/{field}")
	public ResponseEntity<List<PlanterDto>> getAllInSortedOrder(@PathVariable("field") String field)
	{
		return new ResponseEntity<List<PlanterDto>>(planterservice.getAllPlantersInSortingOrder(field),HttpStatus.OK);
	}
	
	/**
	 * Get all the planter records in paginated format.
	 * @param offset
	 * @param pageSize
	 * @return Page(Planter))
	 */
	@GetMapping("/getAllPaginated/{offset}/{pageSize}")
	public ResponseEntity<Page<Planter>> getAllInPaginetion(@PathVariable("offset") int offset,@PathVariable("pageSize") int pageSize)
	{
		return new ResponseEntity<Page<Planter>>(planterservice.getAllPlantersWithPagination(offset, pageSize),HttpStatus.OK);
	}
}
