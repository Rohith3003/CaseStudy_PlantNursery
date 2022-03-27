package com.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.bean.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer> {

}
