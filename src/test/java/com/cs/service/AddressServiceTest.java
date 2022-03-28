package com.cs.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cs.bean.Address;

/**
 * This class provides basic JUnit test cases for AddressService class.
 * 
 * @author Rohith
 *
 */
@SpringBootTest
class AddressServiceTest {
	@Autowired
	IAddressService addressService;

	@Test
	@Disabled
	void addAddressTest() {
		Address address = new Address(303, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Address address1 = addressService.addAddress(address);
		assertEquals(address, address1);
	}

	@Test
	@Disabled
	void getAddressByIdTest() {
		Address address = addressService.getAddresById(15);
		assertEquals(15, address.getAddressId());
		assertEquals("ABC Apartment", address.getBuildingName());
		assertEquals("Hyderabad", address.getCity());
		assertEquals("Telangana", address.getState());
		assertEquals("Raghavendra nagar", address.getColony());
		assertEquals("India", address.getCountry());
		assertEquals(401, address.getFlatNum());
		assertEquals(500079, address.getPincode());
	}

	@Test
	void getAllAddressesTest() {
		List<Address> addresses = addressService.getAllAddresses();
		assertEquals(4, addresses.size());
	}

	@Test
	void updateAddressByIdTest() {
		Address address = new Address(16, 305, "EternalBuiliding", "Saroornagar", "Hyderabad", "Telangana", 500078,
				"India");
		Address updatedAddress = addressService.updateAddressById(16, address);
		assertEquals(address, updatedAddress);
	}

	@Test
	@Disabled
	void deleteAddressbyIdTest() {
		Address address = addressService.deleteAddressById(15);
		assertEquals(15, address.getAddressId());
		assertEquals("ABC Apartment", address.getBuildingName());
		assertEquals("Hyderabad", address.getCity());
		assertEquals("Telangana", address.getState());
		assertEquals("Raghavendra nagar", address.getColony());
		assertEquals("India", address.getCountry());
		assertEquals(401, address.getFlatNum());
		assertEquals(500079, address.getPincode());
	}

}
