package com.cs.service;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.cs.bean.EndUser;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;




public interface ICustomerService {
	//To add new Customer
	RegisterOutputDto addCustomer(Register register);
	//Get customer dto by id
	RegisterOutputDto getCustomerDtoById(Integer id); 
	//Get customer by id
	EndUser getCustomerById(Integer id);
	//Get customer using first name
	List<RegisterOutputDto> getCustomersByName(String fullName);
    //Get customer by Email Id
  	RegisterOutputDto getCustomerByEmailId(String emailId);
  	//Get customer by Mobile Number
  	RegisterOutputDto getCustomerByMobileNumber(String mobileNumber);
	//Get all Customers
	List<RegisterOutputDto> getAllCustomerDto();
	List<EndUser> getAllCustomer();
	//Update Email address
	String updateEmail(String oldEmailId,
			@NotEmpty(message = "Field must not be Empty")
			@Email
			String newEmailId);
	//Update First Name
	String updateName(Integer id,
			@NotEmpty(message = "Field must not be Empty")
			@Pattern(regexp = "[a-zA-Z[\\s]]{3,50}",
			message = "Name should not have any digit or special character")
			String fullName);
	//Update First Name
	String updateMobileNumber(Integer id,
			@NotEmpty(message = "Field must not be Empty")
			@Pattern(regexp = "^(9|7|8)([0-9]){9}$",
			message = "Please enter valid mobile number")	
			String mobileNumber);
	//delete a customer 
	RegisterOutputDto deleteCustomerById(Integer id);
	//delete a customer by email
	RegisterOutputDto deleteCustomerByEmailId(String emailId);
}
