package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents the address entity for user. Consists of 8 members
 * addressId, flatNum, buildingName, colony, city, state, pincode and country.
 * 
 * @author Rohith
 * @version 1.0.0
 * @since 28-03-2022
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {

	@Id
	@GeneratedValue
	int addressId;
	int flatNum;
	String buildingName;
	String colony;
	String city;
	String state;
	int pincode;
	String country;

	/**
	 * Parameterized Constructor
	 * 
	 * @param flatNum
	 * @param buildingName
	 * @param colony
	 * @param city
	 * @param state
	 * @param pincode
	 * @param country
	 */
	public Address(int flatNum, String buildingName, String colony, String city, String state, int pincode,
			String country) {
		super();
		this.flatNum = flatNum;
		this.buildingName = buildingName;
		this.colony = colony;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
	}

}
