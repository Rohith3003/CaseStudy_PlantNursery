package com.cs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs.bean.Address;
import com.cs.repository.IAddressRepository;

@Service
public class AddressServiceImp implements IAddressService {
	
	@Autowired
	IAddressRepository addressRepo;

	//adds new address to database.
	@Override
	public Address addAddress(Address address) {
		return addressRepo.save(address);
	}

	//deletes address of given id from database.
	@Override
	public String deleteAddressById(int id) {
		addressRepo.deleteById(id);
		return "Address with the given id: "+id+" is successfully removed";
	}

	//updates the existing address of given id in database. 
	@Override
	public Address updateAddressById(int id, Address address) {
		
		Optional<Address> opt = addressRepo.findById(id);
		opt.get().setBuildingName(address.getBuildingName());
		opt.get().setCity(address.getCity());
		opt.get().setColony(address.getColony());
		opt.get().setCountry(address.getCountry());
		opt.get().setFlatNum(address.getFlatNum());
		opt.get().setPincode(address.getPincode());
		return addressRepo.save(opt.get());
	}

	
	//retrieves the address of given id from database
	@Override
	public Address getAddresById(int id) {
		
		return addressRepo.findById(id).get();
	}

	
	//retrieves the list of all available addresses in database
	@Override
	public List<Address> getAllAddresses() {
		return addressRepo.findAll();
	}
	
	

}
