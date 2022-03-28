package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.bean.Address;

/**
 * This interface acts as repository which communicates with database and
 * executes all the queries coming from AddressService to database
 * 
 * @author Rohith(Employee id: 46191986)
 * @version 1.0.0
 * @since 28-03-2022
 *
 */
public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
