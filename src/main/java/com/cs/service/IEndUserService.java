package com.cs.service;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.cs.bean.Address;
import com.cs.bean.Cart;
import com.cs.bean.EndUser;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;

public interface IEndUserService {
	// To add new Customer
	// EndUser addCustomer(EndUser endUser);
	RegisterOutputDto addCustomer(Register register);

	// Get all Customers
	List<RegisterOutputDto> getAllCustomerDto();

	// Get all Customers
	List<EndUser> getAllCustomer();

	// Get customer dto by id
	RegisterOutputDto getCustomerDtoById(Integer id);

	// Get customer by id
	EndUser getCustomerById(Integer id);

	// Get customer using first name
	List<RegisterOutputDto> getCustomersByName(String fullName);

	// Get customer by Email Id
	RegisterOutputDto getCustomerByEmailId(String emailId);

	// Get customer by Mobile Number
	RegisterOutputDto getCustomerByMobileNumber(String mobileNumber);
	
	// Update First Name
	String updateName(Integer id,
			@NotEmpty(message = "Field must not be Empty")
			@Pattern(regexp = "[a-zA-Z[\\s]]{3,50}", message = "Name should not have any digit or special character")
				String fullName);
	
	// Update Mobile Number
	String updateMobileNumber(Integer id,
			@NotEmpty(message = "Field must not be Empty") @Pattern(regexp = "^(9|7|8)([0-9]){9}$", message = "Please enter valid mobile number") String mobileNumber);

	// delete a customer
	RegisterOutputDto deleteCustomerById(Integer id);

	// delete a customer by email
	RegisterOutputDto deleteCustomerByEmailId(String emailId);
	
	//Update address in the customer
	RegisterOutputDto updateCustomerAddress(Integer customerId,Address address);
	
	//Get customers cartId
	int getCustomerCartId(Integer customerId);
	
	
	//Get customers cartPrice
	double getCustomerCartPrice(Integer customerId);
	
	
	//Get customer cart Products
	Cart getCustomersCartProducts(Integer customerId);
	
	//Change Password for customer login 
	public String updatePassword(String email, String oldPassword, 
			@NotEmpty(message = "Field must not be Empty")
			@Pattern(regexp = "^(([a-z])|([A-Z])|([!@#$&*])|([0-9])){8,12}$",
            message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit and should be atleast 8 letters")
			String newPassword, String confirmNewPassword);
}
