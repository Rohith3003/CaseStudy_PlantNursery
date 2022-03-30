package com.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.Address;
import com.cs.bean.EndUser;
import com.cs.exception.AddressNotFoundException;
import com.cs.repository.IAddressRepository;
import com.cs.repository.IEndUserRepository;

/**
 * This class is used to provide services to AddressController so that we can
 * add, delete, update and retrieve the address into or from database
 * 
 * @author Rohith(Employee id: 46191986)
 *
 */
@Service
public class AddressServiceImp implements IAddressService {

	@Autowired
	IAddressRepository addressRepo;

	@Autowired
	IEndUserRepository endUserRepo;

	/**
	 * Adds new address to user and persists it in database.
	 * 
	 * @param address
	 * @return Returns the address object which is added to database.
	 */
	@Override
	public Address addAddress(int userId, Address address) {
		EndUser user = endUserRepo.getById(userId);
		user.setAddress(address);
		endUserRepo.save(user);
		return addressRepo.save(address);
	}

	/**
	 * Retrieves the address of given id from database
	 * 
	 * @param id
	 * @return if the given id is present in database then returns corresponding
	 *         address object else returns null.
	 */
	@Override
	public Address getAddresById(int id) {

		Optional<Address> address = addressRepo.findById(id);
		if (!address.isPresent()) {
			throw new AddressNotFoundException("Address with the given id: " + id + " does not exist.");
		}
		return address.get();
	}

	/**
	 * Retrieves the list of all available addresses in database.
	 * 
	 * @return returns the list of addresses from database.
	 */
	@Override
	public List<Address> getAllAddresses() {
		List<Address> addresses = addressRepo.findAll();
		if (addresses.isEmpty()) {
			throw new AddressNotFoundException(
					"The address list is empty in the database. Please add some before retrieving");
		}
		return addresses;
	}

	/**
	 * Updates the existing address of given id in database.
	 * 
	 * @param id      addressId
	 * @param address updatedAddress
	 * @return Returns the updated address object.
	 */
	@Override
	public Address updateAddressById(int id, Address address) {

		Optional<Address> oldAddress = addressRepo.findById(id);
		if (!oldAddress.isPresent()) {
			throw new AddressNotFoundException("Address with the given id: " + id + " does not exist.");
		}
		oldAddress.get().setBuildingName(address.getBuildingName());
		oldAddress.get().setCity(address.getCity());
		oldAddress.get().setColony(address.getColony());
		oldAddress.get().setCountry(address.getCountry());
		oldAddress.get().setFlatNum(address.getFlatNum());
		oldAddress.get().setPincode(address.getPincode());
		oldAddress.get().setState(address.getState());
		return addressRepo.save(oldAddress.get());
	}

	/**
	 * Deletes the address of given id from database.
	 * 
	 * @param id
	 * @return Returns the address object which is deleted from database.
	 */
	@Override
	public Address deleteAddressById(int id) {
		Optional<Address> address = addressRepo.findById(id);
		if (!address.isPresent()) {
			throw new AddressNotFoundException("Address with the given id: " + id + " does not exist.");
		}
		addressRepo.deleteById(id);
		return address.get();
	}
}
