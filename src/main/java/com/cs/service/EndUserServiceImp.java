package com.cs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.cs.bean.Address;
import com.cs.bean.Cart;
import com.cs.bean.EndUser;
import com.cs.bean.Login;
import com.cs.bean.OrderDetails;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;
import com.cs.exception.CustomerNotFoundException;
import com.cs.exception.DuplicateEmailIdException;
import com.cs.exception.DuplicateMobileNumbersException;
import com.cs.exception.PasswordDoNotMatchException;
import com.cs.repository.IAddressRepository;
import com.cs.repository.ICartRepository;
import com.cs.repository.IEndUserRepository;
import com.cs.repository.ILoginRepository;

@Service
@Validated
public class EndUserServiceImp implements IEndUserService {

	@Autowired
	IEndUserRepository endUserRepository;
	@Autowired
	ILoginRepository loginRepository;
	@Autowired
	ICartRepository cartRepository;
	@Autowired
	IAddressRepository addressRepository;

	@Override
	public RegisterOutputDto addCustomer(Register register) {
		EndUser newCustomer = new EndUser();
		newCustomer.setFullName(register.getName());
		newCustomer.setMobileNumber(register.getMobileNumber());
		EndUser customer = endUserRepository.getByMobileNumber(register.getMobileNumber());
		if (customer != null) {
			throw new DuplicateMobileNumbersException(
					"Customer with the given phone number already exists, try registering using other mobile number");
		}
		customer = null;
		if (!register.getPassword().equals(register.getConfirmPassword())) {
			throw new PasswordDoNotMatchException("Confirm password and Password donot match exception");
		}
		newCustomer.setAdmin(register.isAdmin());
		customer = endUserRepository.getByEmailId(register.getEmailId());
		if (customer != null) {
			throw new DuplicateEmailIdException(
					"Customer with the given email Id already exists, try registering using other email id or login though this mail Id");
		}
		Login login = new Login();
		login.setEmail(register.getEmailId());
		login.setPassword(register.getPassword());
		newCustomer.setLogin(login);
		Cart cart = new Cart();
		newCustomer.setCart(cart);
		Address address = new Address();
		newCustomer.setAddress(address);
		endUserRepository.save(newCustomer);
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(newCustomer.getLogin().getEmail());
		registerDto.setName(newCustomer.getFullName());
		registerDto.setMobileNumber(newCustomer.getMobileNumber());
		registerDto.setCartId(newCustomer.getCart().getCartId());
		registerDto.setAddress(newCustomer.getAddress());
		return registerDto;
	}

	@Override
	public List<RegisterOutputDto> getAllCustomerDto() {

		List<EndUser> customers = endUserRepository.findAll();
		List<RegisterOutputDto> registerOuput = new ArrayList<>();

		for (EndUser customer : customers) {
			RegisterOutputDto newRegisterOuput = new RegisterOutputDto();
			newRegisterOuput.setName(customer.getFullName());
			newRegisterOuput.setMobileNumber(customer.getMobileNumber());
			newRegisterOuput.setEmailId(customer.getLogin().getEmail());
			newRegisterOuput.setCartId(customer.getCart().getCartId());
			newRegisterOuput.setAddress(customer.getAddress());
			registerOuput.add(newRegisterOuput);
		}
		return registerOuput;
	}

	@Override
	public List<EndUser> getAllCustomer() {

		return endUserRepository.findAll();
	}

	@Override
	public RegisterOutputDto getCustomerDtoById(Integer id) {
		Optional<EndUser> opt = endUserRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser updatedCustomer = endUserRepository.getById(id);
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(updatedCustomer.getLogin().getEmail());
		registerDto.setName(updatedCustomer.getFullName());
		registerDto.setMobileNumber(updatedCustomer.getMobileNumber());
		registerDto.setCartId(updatedCustomer.getCart().getCartId());
		registerDto.setAddress(updatedCustomer.getAddress());
		return registerDto;
	}

	@Override
	public EndUser getCustomerById(Integer id) {
		Optional<EndUser> opt = endUserRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser customer = endUserRepository.getById(id);

		return customer;
	}

	@Override
	public List<RegisterOutputDto> getCustomersByName(String fullName) {
		List<EndUser> customers = endUserRepository.getAllByFullName(fullName);
		List<RegisterOutputDto> registerOuput = new ArrayList<>();
		for (EndUser customer : customers) {
			RegisterOutputDto newRegisterOuput = new RegisterOutputDto();
			newRegisterOuput.setEmailId(customer.getLogin().getEmail());
			newRegisterOuput.setName(customer.getFullName());
			newRegisterOuput.setMobileNumber(customer.getMobileNumber());
			newRegisterOuput.setCartId(customer.getCart().getCartId());
			newRegisterOuput.setAddress(customer.getAddress());
			registerOuput.add(newRegisterOuput);
		}
		return registerOuput;
	}

	@Override
	public RegisterOutputDto getCustomerByEmailId(String emailId) {
		EndUser customer = endUserRepository.getByEmailId(emailId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + emailId);
		}
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(customer.getLogin().getEmail());
		registerDto.setName(customer.getFullName());
		registerDto.setMobileNumber(customer.getMobileNumber());
		registerDto.setCartId(customer.getCart().getCartId());
		registerDto.setAddress(customer.getAddress());
		return registerDto;
	}

	@Override
	public RegisterOutputDto getCustomerByMobileNumber(String mobileNumber) {

		EndUser customer = endUserRepository.getByMobileNumber(mobileNumber);
		if (customer == null) {
			throw new CustomerNotFoundException(
					"Customer not found with given reference mobile number : " + mobileNumber);
		}
		RegisterOutputDto registerDto = new RegisterOutputDto();
		registerDto.setEmailId(customer.getLogin().getEmail());
		registerDto.setName(customer.getFullName());
		registerDto.setMobileNumber(mobileNumber);
		registerDto.setCartId(customer.getCart().getCartId());
		registerDto.setAddress(customer.getAddress());
		return registerDto;
	}

	@Override
	public String updateName(Integer id,
			@NotEmpty(message = "Field must not be Empty") @Pattern(regexp = "[a-zA-Z[\\s]]{3,50}", message = "Name should not have any digit or special character") String fullName) {
		Optional<EndUser> opt = endUserRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser updatedCustomer = endUserRepository.getById(id);
		updatedCustomer.setFullName(fullName);
		endUserRepository.save(updatedCustomer);
		return "Full name is successfully updated";
	}

	@Override
	public String updateMobileNumber(Integer id,
			@NotEmpty(message = "Field must not be Empty") @Pattern(regexp = "^(9|7|8)([0-9]){9}$", message = "Please enter valid mobile number") String mobileNumber) {

		Optional<EndUser> opt = endUserRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser updatedCustomer = endUserRepository.getById(id);
		updatedCustomer.setMobileNumber(mobileNumber);
		try {
			endUserRepository.save(updatedCustomer);
			return "Mobile Number is successfully updated";
		} catch (DataIntegrityViolationException exception) {
			throw new DataIntegrityViolationException(
					"Customer with the given phone number already exists, try registering using other mobile number");
		}

	}

	@Override
	public RegisterOutputDto deleteCustomerById(Integer id) {

		Optional<EndUser> opt = endUserRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser customer = endUserRepository.getById(id);
		RegisterOutputDto register = new RegisterOutputDto();
		register.setEmailId(customer.getLogin().getEmail());
		register.setName(customer.getFullName());
		register.setMobileNumber(customer.getMobileNumber());
		register.setCartId(customer.getCart().getCartId());
		register.setAddress(customer.getAddress());
		endUserRepository.deleteById(customer.getId());
		return register;
	}

	@Override
	public RegisterOutputDto deleteCustomerByEmailId(String emailId) {

		EndUser customer = endUserRepository.getByEmailId(emailId);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + emailId);
		}
		RegisterOutputDto register = new RegisterOutputDto();
		register.setEmailId(customer.getLogin().getEmail());
		register.setName(customer.getFullName());
		register.setMobileNumber(emailId);
		register.setCartId(customer.getCart().getCartId());
		register.setAddress(customer.getAddress());
		endUserRepository.delete(customer);
		return register;
	}

	@Override
	public RegisterOutputDto updateCustomerAddress(Integer customerId, Address address) {
		Optional<EndUser> opt = endUserRepository.findById(customerId);
		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + customerId);
		}
		EndUser customer = endUserRepository.getById(customerId);
		RegisterOutputDto register = new RegisterOutputDto();
		register.setEmailId(customer.getLogin().getEmail());
		register.setName(customer.getFullName());
		register.setMobileNumber(customer.getMobileNumber());
		register.setCartId(customer.getCart().getCartId());
		register.setAddress(address);
		customer.getAddress().setBuildingName(address.getBuildingName());
		customer.getAddress().setCity(address.getCity());
		customer.getAddress().setColony(address.getColony());
		customer.getAddress().setCountry(address.getCountry());
		customer.getAddress().setFlatNum(address.getFlatNum());
		customer.getAddress().setPincode(address.getPincode());
		customer.getAddress().setState(address.getState());
		endUserRepository.save(customer);
		return register;
		// return null;
	}

	@Override
	public int getCustomerCartId(Integer customerId) {
		Optional<EndUser> opt = endUserRepository.findById(customerId);
		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + customerId);
		}
		EndUser customer = endUserRepository.getById(customerId);
		return customer.getCart().getCartId();
	}

	@Override
	public String updatePassword(String email, String oldPassword,
			@NotEmpty(message = "Field must not be Empty") @Pattern(regexp = "^(([a-z])|([A-Z])|([!@#$&*])|([0-9])){8,12}$", message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit and should be atleast 8 letters") String newPassword,
			String confirmNewPassword) {
		EndUser customer = endUserRepository.getByEmailId(email);
		if (customer == null) {
			throw new CustomerNotFoundException("Customer not found with given reference Email Id : " + email);
		}

		if (!oldPassword.equals(customer.getLogin().getPassword())) {
			throw new PasswordDoNotMatchException("Password donot match");
		}
		if (!newPassword.equals(confirmNewPassword)) {
			throw new PasswordDoNotMatchException("Confirm password and Password donot match exception");
		}
		customer.getLogin().setPassword(newPassword);
		endUserRepository.save(customer);
		return "Password is updated successfully";
	}

	@Override
	public double getCustomerCartPrice(Integer id) {
		Optional<EndUser> opt = endUserRepository.findById(id);

		if (!opt.isPresent()) {
			throw new CustomerNotFoundException("Customer not found with given reference id : " + id);
		}
		EndUser customer = endUserRepository.getById(id);

		customer.getCart().getCartCost();
		return 0;
	}

}
