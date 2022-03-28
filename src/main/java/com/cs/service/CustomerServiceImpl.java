package com.cs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cs.bean.EndUser;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;
import com.cs.exception.CustomerNotFoundException;
import com.cs.exception.PasswordDoNotMatchException;
import com.cs.repository.ICustomerRepository;

@Service
@Validated
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public RegisterOutputDto addCustomer(Register register) {
		// TODO Auto-generated method stub
		try 
		{
			EndUser newCustomer = new EndUser();
			newCustomer.setFullName(register.getName());
			newCustomer.setEmailId(register.getEmailId());
			newCustomer.setMobileNumber(register.getMobileNumber());
			if(!register.getPassword().equals(register.getConfirmPassword())) {
				throw new PasswordDoNotMatchException("Confirm password and Password donot match exception");
			}
			newCustomer.setAdmin(register.isAdmin());
			customerRepository.save(newCustomer);
			RegisterOutputDto registerDto = new RegisterOutputDto();
			registerDto.setEmailId(newCustomer.getEmailId());
			registerDto.setName(newCustomer.getFullName());
			return registerDto;
		} 
		catch (DataIntegrityViolationException exception) 
		{
			//Customer customer1 = customerRepository.findByEmailId(register.getEmailId());
			EndUser customer2 = customerRepository.getByMobileNumber(register.getMobileNumber());
			if (customer2 != null) 
			{
				throw new DataIntegrityViolationException(
						"Customer with the given phone number already exists, try registering using other mobile number");
			}
			else
			{
				throw new DataIntegrityViolationException(
						"Customer with the given email id already exists, try registering using other email id");
				
			}
		} 
		catch (InvalidDataAccessResourceUsageException exception) 
		{
			throw new InvalidDataAccessResourceUsageException("Relation \'customer\' does not exist");
		}
		
	}

	@Override
	public List<RegisterOutputDto> getAllCustomerDto() {
		// TODO Auto-generated method stub
		List<EndUser> customers = customerRepository.findAll();
		List<RegisterOutputDto> registerOuput = new ArrayList<>();
		RegisterOutputDto newRegisterOuput = new RegisterOutputDto();
		for (EndUser customer : customers) {
			newRegisterOuput.setEmailId(customer.getEmailId());
			newRegisterOuput.setName(customer.getFullName());
			registerOuput.add(newRegisterOuput);
		}
		return registerOuput;
	}

	@Override
	public List<EndUser> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	
	@Override
	public RegisterOutputDto getCustomerDtoById(Integer id) {
		// TODO Auto-generated method stub
		Optional<EndUser> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser updatedCustomer = customerRepository.getById(id);
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(updatedCustomer.getEmailId());
		registerDto.setName(updatedCustomer.getFullName());
		return registerDto;
	}
	
	
	@Override
	public EndUser getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Optional<EndUser> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser customer = customerRepository.getById(id);
		
		return customer;
	}

	@Override
	public List<RegisterOutputDto> getCustomersByName(String fullName) 
	{
		// TODO Auto-generated method stub
		List<EndUser> customers = customerRepository.getAllByFullName(fullName);
		List<RegisterOutputDto> registerOuput = new ArrayList<>();
		RegisterOutputDto newRegisterOuput = new RegisterOutputDto();
		for (EndUser customer : customers) {
			newRegisterOuput.setEmailId(customer.getEmailId());
			newRegisterOuput.setName(customer.getFullName());
			registerOuput.add(newRegisterOuput);
		}
		return registerOuput;
	}


	@Override
	public RegisterOutputDto getCustomerByMobileNumber(String mobileNumber) {
		// TODO Auto-generated method stub
		EndUser customer = customerRepository.getByMobileNumber(mobileNumber);
		if (customer == null) {
			throw new CustomerNotFoundException(
					"Customer not found with given reference mobile number : " + mobileNumber);
		}
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(customer.getEmailId());
		registerDto.setName(customer.getFullName());
		return registerDto;
	}

	@Override
	public RegisterOutputDto getCustomerByEmailId(String emailId) {
		// TODO Auto-generated method stub
		EndUser customer = customerRepository.findByEmailId(emailId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + emailId);
		}
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(customer.getEmailId());
		registerDto.setName(customer.getFullName());
		return registerDto;
	}

	@Override
	public String updateEmail(String oldEmailId,
			@NotEmpty(message = "Field must not be Empty")
			@Email
			String newEmailId) {
		// TODO Auto-generated method stub
		EndUser updatedCustomer = customerRepository.findByEmailId(oldEmailId);
		if (updatedCustomer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + oldEmailId);
		}
		updatedCustomer.setEmailId(newEmailId);
		try 
		{
			customerRepository.save(updatedCustomer);
			return "EmailId is successfully updated";
		}
		catch (DataIntegrityViolationException exception) 
		{
			throw new DataIntegrityViolationException(
					"Customer with the given email id already exists, try registering using other email id");
		}
	}
	
	@Override
	public String updateMobileNumber(Integer id,
			@NotEmpty(message = "Field must not be Empty")
			@Pattern(regexp = "^(9|7|8)([0-9]){9}$",
			message = "Please enter valid mobile number")	
			String mobileNumber) {
		// TODO Auto-generated method stub
		Optional<EndUser> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser updatedCustomer = customerRepository.getById(id);
		updatedCustomer.setMobileNumber(mobileNumber);
		try {
			customerRepository.save(updatedCustomer);
			return "Mobile Number is successfully updated";
		}
		catch (DataIntegrityViolationException exception) {
			throw new DataIntegrityViolationException(
					"Customer with the given phone number already exists, try registering using other mobile number");
		}
		
	}


	@Override
	public String updateName(Integer id, 
			@NotEmpty(message = "Field must not be Empty")
			@Pattern(regexp = "[a-zA-Z[\\s]]{3,50}",
			message = "Name should not have any digit or special character")
			String fullName) {
		Optional<EndUser> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser updatedCustomer = customerRepository.getById(id);
		updatedCustomer.setFullName(fullName);
		customerRepository.save(updatedCustomer);
		return "Full name is successfully updated";
	}

	/*
	@Override
	public String updatePassword(Integer id, String oldPassword, String newPassword, String confirmNewPassword) {
		// TODO Auto-generated method stub
		Optional<Customer> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		Customer updatedCustomer = customerRepository.getById(id);
		/*
		 * if(oldPassword.equals(toBeUpdateCustomer.getPassword())) { //throw new ; }
		 * else if(!newPassword.equals(confirmNewPassword)) {
		 * 
		 * } else
		 
		updatedCustomer.setPassword(newPassword);
		customerRepository.save(updatedCustomer);
		return "Password changed successfully";
	}
		*/

	@Override
	public RegisterOutputDto deleteCustomerById(Integer id) {
		// TODO Auto-generated method stub
		Optional<EndUser> opt = customerRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser customer = customerRepository.getById(id);
		RegisterOutputDto register = new RegisterOutputDto();
		register.setEmailId(customer.getEmailId());
		register.setName(customer.getFullName());
		customerRepository.delete(customer);
		return register;
	}

	@Override
	public RegisterOutputDto deleteCustomerByEmailId(String emailId) {
		// TODO Auto-generated method stub
		EndUser customer = customerRepository.findByEmailId(emailId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + emailId);
		}
		RegisterOutputDto register = new RegisterOutputDto();
		register.setEmailId(customer.getEmailId());
		register.setName(customer.getFullName());
		customerRepository.delete(customer);
		return register;
	}

	
	
}
