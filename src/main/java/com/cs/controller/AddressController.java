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

@RestController
public class AddressController {
	
	@Autowired
	IAddressService addressService;
	
	@PostMapping("/addAddress")
	ResponseEntity<Address> addAddress(@RequestBody Address address)
	{
		return new ResponseEntity<Address>(addressService.addAddress(address),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteAddress/{id}")
	ResponseEntity<String> deleteAddressById(@PathVariable("id") int id)
	{
		return new ResponseEntity<String>(addressService.deleteAddressById(id),HttpStatus.OK);
	}
	
	@PutMapping("/updateAddress/{id}")
	ResponseEntity<Address> updateAddressById(@PathVariable("id") int id, @RequestBody Address address)
	{
		return new ResponseEntity<Address>(addressService.updateAddressById(id, address),HttpStatus.OK);
	}
	
	@GetMapping("address/{id}")
	ResponseEntity<Address> getAddressById(@PathVariable int id)
	{
		return new ResponseEntity<Address>(addressService.getAddresById(id),HttpStatus.OK);
	}

	@GetMapping("/allAddresses")
	ResponseEntity<List<Address>> getAllAddresses()
	{
		return new ResponseEntity<List<Address>>(addressService.getAllAddresses(),HttpStatus.OK);
	}
}
