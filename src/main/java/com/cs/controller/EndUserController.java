package com.cs.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cs.bean.Address;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;
import com.cs.service.IEndUserService;

/*
 * This class acts as a controller for EndUser object,
 * which consists of create,update,retrieve and delete methods
 * in database.
 * 
 *  @author Sapala Srusti Vemula
 */

@RestController
public class EndUserController {

	@Autowired
	IEndUserService endUserService;

	@PostMapping("/customers")
	ResponseEntity<RegisterOutputDto> addCustomer(@Valid @RequestBody Register register) {
		RegisterOutputDto newRegisterDto = endUserService.addCustomer(register);
		return new ResponseEntity<RegisterOutputDto>(newRegisterDto, HttpStatus.CREATED);
	}

	@GetMapping("/customers")
	ResponseEntity<List<RegisterOutputDto>> getAllCustomers() {
		List<RegisterOutputDto> getAllCustomers = endUserService.getAllCustomerDto();
		return new ResponseEntity<>(getAllCustomers, HttpStatus.OK);
	}

	@GetMapping("/customer/byId")
	ResponseEntity<RegisterOutputDto> getCustomerById(@RequestParam Integer id) {
		RegisterOutputDto customer = endUserService.getCustomerDtoById(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/customer/emailId")
	ResponseEntity<RegisterOutputDto> getACustomerByEmailId(@RequestParam String emailId) {
		RegisterOutputDto customer = endUserService.getCustomerByEmailId(emailId);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/customers/firstName")
	ResponseEntity<List<RegisterOutputDto>> getAllCustomersByFirstName(@RequestParam String fullName) {
		List<RegisterOutputDto> getAllCustomers = endUserService.getCustomersByName(fullName);
		return new ResponseEntity<>(getAllCustomers, HttpStatus.OK);
	}

	@GetMapping("/customer/mobileNumber")
	ResponseEntity<RegisterOutputDto> getACustomerByMobileNumber(@RequestParam String mobileNumber) {
		RegisterOutputDto customer = endUserService.getCustomerByMobileNumber(mobileNumber);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@GetMapping("/customer/cartId")
	ResponseEntity<Integer> getACustomerCartId(@RequestParam Integer custId) {
		Integer cartId = endUserService.getCustomerCartId(custId);
		return new ResponseEntity<>(cartId, HttpStatus.OK);
	}

	@GetMapping("/customer/cartId/cartPrice")
	ResponseEntity<Double> getACustomerCartPrice(@RequestParam Integer custId) {
		Double cartPrice = endUserService.getCustomerCartPrice(custId);
		return new ResponseEntity<>(cartPrice, HttpStatus.OK);
	}

	@PatchMapping("/customer/updateFull_name")
	ResponseEntity<String> updateFirstName(@Valid @RequestParam Integer id, @RequestParam String fullName) {
		String message = endUserService.updateName(id, fullName);
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/customer/updateMobileNumber")
	ResponseEntity<String> updateMobileNumber(@Valid @RequestParam Integer id, @RequestParam String mobileNumber) {
		String message = endUserService.updateMobileNumber(id, mobileNumber);
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/customer/address")
	ResponseEntity<RegisterOutputDto> updateAddress(@RequestParam Integer id, @RequestBody Address address) {
		RegisterOutputDto register = endUserService.updateCustomerAddress(id, address);
		return new ResponseEntity<>(register, HttpStatus.ACCEPTED);
	}

	@PatchMapping("/customer/changePassword")
	ResponseEntity<String> updateCustomerPassword(@Valid @RequestParam String email, @RequestParam String oldPassword,
			@RequestParam String newPassword, @RequestParam String confirmNewPassword) {
		String message = endUserService.updatePassword(email, oldPassword, newPassword, confirmNewPassword);
		return new ResponseEntity<>(message, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteCustomer")
	ResponseEntity<RegisterOutputDto> deleteCustomer(@RequestParam Integer id) {
		RegisterOutputDto registerDto = endUserService.deleteCustomerById(id);
		return new ResponseEntity<>(registerDto, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteCustomer/byEmailId")
	ResponseEntity<RegisterOutputDto> deleteCustomerByEmailId(@RequestParam String emailId) {
		RegisterOutputDto registerDto = endUserService.deleteCustomerByEmailId(emailId);
		return new ResponseEntity<>(registerDto, HttpStatus.ACCEPTED);
	}

}
