package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Address;
import com.cs.bean.EndUser;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;

@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	IEndUserService endUserService;

	@Test
	@Disabled
	void addCustomerTest() {
		Register register = new Register("Abhilash", "abhi1245@gmail.com", "Abhi@12", "Abhi@12", "9546464657", false);
		RegisterOutputDto registerDto = endUserService.addCustomer(register);
		assertEquals("Abhilash", registerDto.getName());
		assertEquals("abhi1245@gmail.com", registerDto.getEmailId());
	}

	@Test
	@Disabled
	void getCustomerByIdTest() {
		EndUser customer = endUserService.getCustomerById(1);
		assertEquals("Karthikeya Alturi", customer.getFullName());
		assertEquals("8764310871", customer.getMobileNumber());
		assertEquals("karthikalturi12@gmail.com", customer.getLogin().getEmail());
	}

	@Test
	@Disabled
	void getCustomerDtoByIdTest() {
		RegisterOutputDto registerDto = endUserService.getCustomerDtoById(1);
		assertEquals("karthikalturi12@gmail.com", registerDto.getEmailId());
		assertEquals("Karthikeya Alturi", registerDto.getName());
	}

	@Test
	@Disabled
	void getCustomerByEmailIdTest() {
		RegisterOutputDto registerDto = endUserService.getCustomerByEmailId("karthikalturi12@gmail.com");
		assertEquals("karthikalturi12@gmail.com", registerDto.getEmailId());
		assertEquals("Karthikeya Alturi", registerDto.getName());
	}

	@Test
	void getCustomerByNameTest() {
		List<RegisterOutputDto> registerDtos = endUserService.getCustomersByName("Karthik");
		assertEquals(3, registerDtos.size());
	}

	@Test
	@Disabled
	void getCustomerByMobileNumberTest() {
		RegisterOutputDto registerDto = endUserService.getCustomerByMobileNumber("8764310871");
		assertEquals("karthikalturi123@gmail.com", registerDto.getEmailId());
		assertEquals("Karthikeya Alturi", registerDto.getName());
	}

	@Test
	void getAllCustomersDtoTest() {
		List<RegisterOutputDto> customersDto = endUserService.getAllCustomerDto();
		assertEquals(4, customersDto.size());
	}

	@Test
	void getAllCustomersTest() {
		List<EndUser> customersDto = endUserService.getAllCustomer();
		assertEquals(4, customersDto.size());
	}

	@Test
	void updateNameTest() {
		String output = endUserService.updateName(1, "Abhi");
		assertEquals("Full name is successfully updated", output);
	}

	@Test
	void updateMobileNumber() {
		String output = endUserService.updateMobileNumber(1, "9175787574");
		assertEquals("Mobile Number is successfully updated", output);
	}

	@Test
	@Disabled
	void deleteCustomerByIdTest() {
		RegisterOutputDto registerDto = endUserService.deleteCustomerById(2);
		assertEquals("davansh123@gmail.com", registerDto.getEmailId());
		assertEquals("Devansh", registerDto.getName());
	}

	@Test
	@Disabled
	void deleteCustomerByEmailIdTest() {
		RegisterOutputDto registerDto = endUserService.deleteCustomerByEmailId("rihaan@gmail.com");
		assertEquals("rihaan@gmail.com", registerDto.getEmailId());
		assertEquals("Rihaan", registerDto.getName());

	}

	@Test
	void updateCustomerAddressTest() {
		Address address = new Address(103, "Estate", "Uppal", "Hyd", "Ts", 501010, "India");
		RegisterOutputDto registerDto = endUserService.updateCustomerAddress(3, address);
		assertEquals("karthi@gmail.com", registerDto.getEmailId());
		assertEquals("Karthik", registerDto.getName());
		assertEquals("8485848595", registerDto.getMobileNumber());
		assertEquals(7, registerDto.getCartId());
		assertEquals("Estate", registerDto.getAddress().getBuildingName());
		assertEquals("Hyd", registerDto.getAddress().getCity());
		assertEquals("Uppal", registerDto.getAddress().getColony());
		assertEquals("Hyd", registerDto.getAddress().getCity());
		assertEquals(103, registerDto.getAddress().getFlatNum());
		assertEquals("India", registerDto.getAddress().getCountry());
		assertEquals(501010, registerDto.getAddress().getPincode());

	}

	@Test
	void getCustomerCartId() {
		Integer cartId = endUserService.getCustomerCartId(1);
		assertEquals(4, cartId);

	}

	@Test
	void updatePassword() {
		String message = endUserService.updatePassword("karthik1@gmail.com", "@Karthi!545", "@Karthi!56", "@Karthi!56");
		assertEquals("Password is updated successfully", message);
	}

	@Test
	void getCustomerCartPrice() {
		Double cartPrice = endUserService.getCustomerCartPrice(1);
		assertEquals(0, cartPrice);
	}

}
