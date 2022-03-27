package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class EndUser {
	
	@Id
	@GeneratedValue
	private int customerId;
	private String customerName;
	private String role;

}
