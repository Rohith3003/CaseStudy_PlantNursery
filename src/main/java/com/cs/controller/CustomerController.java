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

import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;
import com.cs.service.ICustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/customers")
	ResponseEntity<RegisterOutputDto> addCustomer(@Valid @RequestBody Register register){
		RegisterOutputDto newRegisterDto = customerService.addCustomer(register);
		return new ResponseEntity<RegisterOutputDto>(newRegisterDto,HttpStatus.CREATED);
	}
	
	@GetMapping("/customers")
	ResponseEntity<List<RegisterOutputDto>> getAllCustomers(){
		List<RegisterOutputDto>  getAllCustomers = customerService.getAllCustomerDto();
		return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
	}
	
	@GetMapping("/customer/byId")
	ResponseEntity<RegisterOutputDto> getCustomerById(@RequestParam Integer id){
		RegisterOutputDto  customer = customerService.getCustomerDtoById(id);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customer/emailId")
	ResponseEntity<RegisterOutputDto> getACustomerByEmailId(@RequestParam String emailId){
		RegisterOutputDto  customer = customerService.getCustomerByEmailId(emailId);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	@GetMapping("/customers/firstName")
	ResponseEntity<List<RegisterOutputDto>> getAllCustomersByFirstName(@RequestParam String fullName){
		List<RegisterOutputDto>  getAllCustomers = customerService.getCustomersByName(fullName);
		return new ResponseEntity<>(getAllCustomers,HttpStatus.OK);
	}
	

	@GetMapping("/customer/mobileNumber")
	ResponseEntity<RegisterOutputDto> getACustomerByMobileNumber(@RequestParam String mobileNumber){
		RegisterOutputDto  customer = customerService.getCustomerByMobileNumber(mobileNumber);
		return new ResponseEntity<>(customer,HttpStatus.OK);
	}
	
	
	@PatchMapping("/customer/updateEmailId")
	ResponseEntity<String> updateEmailId(@Valid @RequestParam String emailId,@RequestParam String newEmailId){
		String message = customerService.updateEmail(emailId, newEmailId);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
		
	}
	
	@PatchMapping("/customer/updateFull_name")
	ResponseEntity<String> updateFirstName(@Valid @RequestParam Integer id,@RequestParam String fullName){
		String message = customerService.updateName(id, fullName);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/customer/updateMobileNumber")
	ResponseEntity<String> updateMobileNumber(@Valid @RequestParam Integer id,@RequestParam String mobileNumber){
		String message = customerService.updateMobileNumber(id, mobileNumber);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	
	
	/*
	@PatchMapping("/customer/updatePassword")
	ResponseEntity<String> updatePassword(@RequestParam Integer id,@RequestParam String oldPassword,@RequestParam String newPassword,@RequestParam String conformPassword){
		String message = customerService.updatePassword(id, oldPassword, newPassword, newPassword);
		return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
	}
	*/
	@DeleteMapping("/deleteCustomer")
	ResponseEntity<RegisterOutputDto> deleteCustomer(@RequestParam Integer id){
		RegisterOutputDto registerDto = customerService.deleteCustomerById(id);
		return new ResponseEntity<>(registerDto,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteCustomer/byEmailId")
	ResponseEntity<RegisterOutputDto> deleteCustomerByEmailId(@RequestParam String emailId){
		RegisterOutputDto registerDto = customerService.deleteCustomerByEmailId(emailId);
		return new ResponseEntity<>(registerDto,HttpStatus.ACCEPTED);
	}
	
	
}
