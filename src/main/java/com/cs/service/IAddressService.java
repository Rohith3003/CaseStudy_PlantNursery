package com.cs.service;

import java.util.List;

import com.cs.bean.Address;

public interface IAddressService {
	
	Address addAddress(Address address);
	String deleteAddressById(int id);
	Address updateAddressById(int id, Address address);
	Address getAddresById(int id);
	List<Address> getAllAddresses();
}
