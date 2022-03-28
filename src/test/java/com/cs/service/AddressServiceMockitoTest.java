package com.cs.service;

import static org.junit.jupiter.api.Assertions.*;

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

import com.cs.bean.Address;
import com.cs.repository.IAddressRepository;

/**
 * This class provides Mockito test cases for AddressService.
 * 
 * @author Rohith(Employee id: 46191986)
 *
 */
@ExtendWith(SpringExtension.class)
class AddressServiceMockitoTest {

	@InjectMocks
	AddressServiceImp addressService;

	@MockBean
	IAddressRepository addressRepo;

	@BeforeEach
	void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void addAddressTest() {
		Address address = new Address(303, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Mockito.when(addressRepo.save(address)).thenReturn(address);
		Address address1 = addressService.addAddress(address);
		assertEquals(address, address1);
	}

	@Test
	void getAddressByIdTest() {

		Address address = new Address(28, 303, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Mockito.when(addressRepo.findById(28)).thenReturn(Optional.of(address));
		Address returnedAddress = addressService.getAddresById(28);
		assertEquals(address, returnedAddress);
	}

	@Test
	void getAllAddressesTest() {
		Address address1 = new Address(28, 303, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Address address2 = new Address(29, 215, "ABCBuiliding", "Dilsukhnagar", "Hyderabad", "Telangana", 500078,
				"India");
		Address address3 = new Address(29, 408, "XYZBuiliding", "Dilsukhnagar", "Hyderabad", "Telangana", 500078,
				"India");
		List<Address> addresses = List.of(address1, address2, address3);
		Mockito.when(addressRepo.findAll()).thenReturn(addresses);
		List<Address> returnedAddresses = addressService.getAllAddresses();
		assertEquals(addresses.size(), returnedAddresses.size());

	}

	@Test
	void updateAddresByIdTest() {
		Address address = new Address(28, 303, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Address address1 = new Address(28, 305, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Mockito.when(addressRepo.findById(28)).thenReturn(Optional.of(address));
		Address returnedAddress = addressService.getAddresById(28);
		assertEquals(address, returnedAddress);
		Mockito.when(addressRepo.save(address)).thenReturn(address1);
		Address updatedAddress = addressService.updateAddressById(28, address1);
		assertEquals(address1, updatedAddress);
	}

	@Test
	void deleteAddressByIdTest() {
		Address address = new Address(28, 303, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Mockito.when(addressRepo.findById(28)).thenReturn(Optional.of(address));
		Address deletedAddress = addressService.deleteAddressById(28);
		assertEquals(address, deletedAddress);
	}
}
