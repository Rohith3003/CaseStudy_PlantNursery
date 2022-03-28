package com.cs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.cs.bean.EndUser;
import com.cs.dto.Register;
import com.cs.dto.RegisterOutputDto;
import com.cs.repository.ICustomerRepository;



@ExtendWith(SpringExtension.class)
public class CustomerServiceMockitoTest {
	
	
	@InjectMocks
	CustomerServiceImpl customerService ;
	
	
	@MockBean
	ICustomerRepository customerRepository;
	
	RegisterOutputDto registerDto;
	
	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void addCustomerTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());		
		Mockito.when(customerRepository.save(customer)).thenReturn(customer);
		RegisterOutputDto registerDto = customerService.addCustomer(register);
		assertEquals("Arun",registerDto.getName());
		assertEquals("ardoing@gmail.com",registerDto.getEmailId());
				
	}
	
	@Test
	void getCustomerDtoByIdTest() throws Exception{
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.findById(22)).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.getById(22)).thenReturn(customer);
		RegisterOutputDto registerDto1  = customerService.getCustomerDtoById(22);
		assertEquals("Arun",registerDto1.getName());
		assertEquals("ardoing@gmail.com",registerDto1.getEmailId());
	}
	
	
	@Test
	void getCustomerByIdTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.findById(22)).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.getById(22)).thenReturn(customer);
		EndUser resultCustomer  = customerService.getCustomerById(22);
		assertEquals("Arun",resultCustomer.getFullName());
		assertEquals("ardoing@gmail.com",resultCustomer.getEmailId());
		assertEquals("8787878889",resultCustomer.getMobileNumber());
		assertEquals(false,resultCustomer.isAdmin());
	}
	
	@Test
	void getAllCustomerTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer1 = new EndUser();
		customer1.setFullName(register.getName());
		customer1.setEmailId(register.getEmailId());
		customer1.setMobileNumber(register.getMobileNumber());
		customer1.setAdmin(false);
		customer1.setId(22);
		Register register1 = new Register("Arun","ardone@gmail.com","ardoin@1","ardoin@1","8787878886",false);
		EndUser customer2 = new EndUser();
		customer2.setFullName(register1.getName());
		customer2.setEmailId(register1.getEmailId());
		customer2.setMobileNumber(register1.getMobileNumber());
		customer2.setAdmin(false);
		customer2.setId(23);
		List<EndUser> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		List<EndUser> resultCustomers = customerService.getAllCustomer();
		assertEquals(2,resultCustomers.size());
		
	}
	
	@Test
	void getAllCustomersDtoTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer1 = new EndUser();
		customer1.setFullName(register.getName());
		customer1.setEmailId(register.getEmailId());
		customer1.setMobileNumber(register.getMobileNumber());
		customer1.setAdmin(false);
		customer1.setId(22);
		Register register1 = new Register("Arun","ardone@gmail.com","ardoin@1","ardoin@1","8787878886",false);
		EndUser customer2 = new EndUser();
		customer2.setFullName(register1.getName());
		customer2.setEmailId(register1.getEmailId());
		customer2.setMobileNumber(register1.getMobileNumber());
		customer2.setAdmin(false);
		customer2.setId(23);
		List<EndUser> customers = new ArrayList<>();
		customers.add(customer1);
		customers.add(customer2);
		Mockito.when(customerRepository.findAll()).thenReturn(customers);
		List<RegisterOutputDto> resultCustomers = customerService.getAllCustomerDto();
		assertEquals(2,resultCustomers.size());
		
	}
	
	@Test
	void getCustomerByNameTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Register register1 = new Register("Arun","ardone@gmail.com","ardoin@1","ardoin@1","8787878886",false);
		EndUser customer2 = new EndUser();
		customer2.setFullName(register1.getName());
		customer2.setEmailId(register1.getEmailId());
		customer2.setMobileNumber(register1.getMobileNumber());
		customer2.setAdmin(false);
		customer2.setId(23);
		List<EndUser> customers = new ArrayList<>();
		customers.add(customer);
		customers.add(customer2);
		Mockito.when(customerRepository.getAllByFullName("Arun")).thenReturn(customers);
		List<RegisterOutputDto> resultCustomers = customerService.getCustomersByName("Arun");
		assertEquals(2,resultCustomers.size());
	}
	
	@Test
	void getCustomerByMobileNumberTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.getByMobileNumber("8787878889")).thenReturn(customer);
		RegisterOutputDto registerDto1  = customerService.getCustomerByMobileNumber("8787878889");
		assertEquals("Arun",registerDto1.getName());
		assertEquals("ardoing@gmail.com",registerDto1.getEmailId());
	}
	
	@Test
	void updateMobileNumberTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.findById(22)).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.getById(22)).thenReturn(customer);
		String resultOfUpdate = customerService.updateMobileNumber(22, "8787868889");
		assertEquals("Mobile Number is successfully updated",resultOfUpdate);	
	}
	
	@Test
	void updateEmailTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.findById(22)).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.findByEmailId("ardoing@gmail.com")).thenReturn(customer);
		String resultOfUpdate = customerService.updateEmail(customer.getEmailId(),"ardoing12@gmail.com");
		assertEquals("EmailId is successfully updated",resultOfUpdate);		
	}
	
	@Test
	void updateNameTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.findById(22)).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.getById(22)).thenReturn(customer);
		String resultOfUpdate = customerService.updateName(22, "Ajay");
		assertEquals("Full name is successfully updated",resultOfUpdate);		
	}
	
	
	
	@Test
	void deleteCustomerByIdTest() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.findById(22)).thenReturn(Optional.of(customer));
		Mockito.when(customerRepository.getById(22)).thenReturn(customer);
		Mockito.doNothing().when(customerRepository).deleteById(22);
		RegisterOutputDto registerDto1 = customerService.deleteCustomerById(22);
		assertEquals("Arun",registerDto1.getName());
		assertEquals("ardoing@gmail.com",registerDto1.getEmailId());
	}
	
	
	@Test
	void deleteCustomerByEmailId() {
		Register register = new Register("Arun","ardoing@gmail.com","ardoin@1","ardoin@1","8787878889",false);
		EndUser customer = new EndUser();
		customer.setFullName(register.getName());
		customer.setEmailId(register.getEmailId());
		customer.setMobileNumber(register.getMobileNumber());
		customer.setAdmin(false);
		customer.setId(22);
		Mockito.when(customerRepository.findByEmailId("ardoing@gmail.com")).thenReturn(customer);
		Mockito.doNothing().when(customerRepository).delete(customer);
		RegisterOutputDto registerDto1 = customerService.deleteCustomerByEmailId("ardoing@gmail.com");
		assertEquals("Arun",registerDto1.getName());
		assertEquals("ardoing@gmail.com",registerDto1.getEmailId());
	}
	
	

}
