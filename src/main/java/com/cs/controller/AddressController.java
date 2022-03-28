package com.cs.controller;

import java.util.List;

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

import com.cs.bean.Address;
import com.cs.service.IAddressService;

/**
 * This class is used as controller to add, delete, update and retrieve
 * fertilizer to and from database
 * 
 * @author Rohith(Employee id: 46191986)
 * @version 1.0.0
 * @since 28-03-2022
 *
 */

@RestController
public class AddressController {

	@Autowired
	IAddressService addressService;

	/**
	 * Adds new address to database.
	 * 
	 * @param address
	 * @return returns the address object which is added to database
	 */
	@PostMapping("/addAddress")
	ResponseEntity<Address> addAddress(@RequestBody Address address) {
		return new ResponseEntity<Address>(addressService.addAddress(address), HttpStatus.OK);
	}

	/**
	 * Deletes the address of given id from database.
	 * 
	 * @param id
	 * @return returns the address object which is deleted from database
	 */
	@DeleteMapping("/deleteAddress/{id}")
	ResponseEntity<Address> deleteAddressById(@PathVariable("id") int id) {
		return new ResponseEntity<Address>(addressService.deleteAddressById(id), HttpStatus.OK);
	}

	/**
	 * Updates the existing address of given id in database.
	 * 
	 * @param id      addressId
	 * @param address updatedAddress
	 * @return returns the updated address object
	 */
	@PutMapping("/updateAddress/{id}")
	ResponseEntity<Address> updateAddressById(@PathVariable("id") int id, @RequestBody Address address) {
		return new ResponseEntity<Address>(addressService.updateAddressById(id, address), HttpStatus.OK);
	}

	/**
	 * Retrieves the address of given id from database
	 * 
	 * @param id
	 * @return if the given id is present in database then returns corresponding
	 *         address object else returns null.
	 */
	@GetMapping("address/{id}")
	ResponseEntity<Address> getAddressById(@PathVariable int id) {
		return new ResponseEntity<Address>(addressService.getAddresById(id), HttpStatus.OK);
	}

	/**
	 * Retrieves the list of all available addresses in database.
	 * 
	 * @return returns the list of addresses from database.
	 */
	@GetMapping("/allAddresses")
	ResponseEntity<List<Address>> getAllAddresses() {
		return new ResponseEntity<List<Address>>(addressService.getAllAddresses(), HttpStatus.OK);
	}
}
