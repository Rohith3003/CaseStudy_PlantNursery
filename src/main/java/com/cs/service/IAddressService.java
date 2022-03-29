package com.cs.service;

import java.util.List;

import com.cs.bean.Address;

/**
 * This Interface is used to define the services provided to AddressController
 * so that we can add, delete, update and retrieve the address into or from
 * database
 * 
 * @author Rohith(Employee id: 46191986)
 *
 * 
 */
public interface IAddressService {

	/**
	 * Adds new address to user and persists it in database.
	 * 
	 * @param address
	 * @return Returns the address object which is added to database.
	 */
	Address addAddress(int userId, Address address);

	/**
	 * Deletes the address of given id from database.
	 * 
	 * @param id
	 * @return Returns the address object which is deleted from database.
	 */
	Address deleteAddressById(int id);

	/**
	 * Updates the existing address of given id in database.
	 * 
	 * @param id      addressId
	 * @param address updatedAddress
	 * @return Returns the updated address object.
	 */
	Address updateAddressById(int id, Address address);

	/**
	 * Retrieves the address of given id from database.
	 * 
	 * @param id
	 * @return if the given id is present in database then returns corresponding
	 *         address object else returns null.
	 */
	Address getAddresById(int id);

	/**
	 * Retrieves the list of all available addresses in database.
	 * 
	 * @return returns the list of addresses from database.
	 */
	List<Address> getAllAddresses();
}
