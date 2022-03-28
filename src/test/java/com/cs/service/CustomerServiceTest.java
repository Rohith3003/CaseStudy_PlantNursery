package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.EndUser;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;



@SpringBootTest
public class CustomerServiceTest {
	
	@Autowired
	ICustomerService customerService;
	
	@Test
	@Disabled
	void addCustomerTest() {
		Register register = new Register("Abhilash","abhi1245@gmail.com","Abhi@12","Abhi@12","9546464657",false);
		RegisterOutputDto registerDto = customerService.addCustomer(register);
		assertEquals("Abhilash",registerDto.getName());
		assertEquals("abhi1245@gmail.com",registerDto.getEmailId());	
	}
	
	
	@Test
	@Disabled
	void getCustomerByIdTest() {
		EndUser customer = customerService.getCustomerById(1);
		assertEquals("Karthikeya Alturi",customer.getFullName());		
		assertEquals("8764310871",customer.getMobileNumber());
		assertEquals("karthikalturi12@gmail.com",customer.getEmailId());		
	}
	
	@Test
	@Disabled
	void getCustomerDtoByIdTest() {
		RegisterOutputDto registerDto = customerService.getCustomerDtoById(1);
		assertEquals("karthikalturi12@gmail.com",registerDto.getEmailId());
		assertEquals("Karthikeya Alturi",registerDto.getName());
	}
	
	@Test
	@Disabled
	void getCustomerByEmailIdTest(){
		RegisterOutputDto registerDto = customerService.getCustomerByEmailId("karthikalturi12@gmail.com");
		assertEquals("karthikalturi12@gmail.com",registerDto.getEmailId());
		assertEquals("Karthikeya Alturi",registerDto.getName());
	}
	
	@Test
	void getCustomerByNameTest() {
		List<RegisterOutputDto> registerDtos = customerService.getCustomersByName("Abhishek");
		assertEquals(3,registerDtos.size());
	}
	
	@Test
	@Disabled
	void getCustomerByMobileNumberTest() {
		RegisterOutputDto registerDto = customerService.getCustomerByMobileNumber("8764310871");
		assertEquals("karthikalturi123@gmail.com",registerDto.getEmailId());
		assertEquals("Karthikeya Alturi",registerDto.getName());
	}
	
	@Test
	void getAllCustomersDtoTest() {
		List<RegisterOutputDto> customersDto = customerService.getAllCustomerDto();
		assertEquals(7,customersDto.size());
	}
	
	@Test
	void getAllCustomersTest() {
		List<EndUser> customersDto = customerService.getAllCustomer();
		assertEquals(7,customersDto.size());
	}
	
	@Test
	@Disabled
	void updateEmailIdTest() {
		String emailid = "abhihek@gmail.com";
		String output = customerService.updateEmail(emailid,"abhi.123@gmail.com");
		assertEquals("EmailId is successfully updated",output);
	}
	
	@Test
	@Disabled
	void updateNameTest() {
		String output = customerService.updateName(11, "Abhi");
		assertEquals("Full name is successfully uploaded",output);
	}
	
	@Test
	void updateMobileNumber() {
		String output = customerService.updateName(11, "9175787574");
		assertEquals("Mobile Number is successfully updated",output);
	}
	
	
	@Test
	@Disabled
	void deleteCustomerByIdTest() {
		RegisterOutputDto registerDto = customerService.deleteCustomerById(2);
		assertEquals("davansh123@gmail.com",registerDto.getEmailId());
		assertEquals("Devansh",registerDto.getName());
	}
	
	@Test
	@Disabled
	void deleteCustomerByEmailIdTest() {
		RegisterOutputDto registerDto = customerService.deleteCustomerByEmailId("rihaan@gmail.com");
		assertEquals("rihaan@gmail.com",registerDto.getEmailId());
		assertEquals("Rihaan",registerDto.getName());
		
	}

}
