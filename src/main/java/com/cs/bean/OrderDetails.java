package com.cs.bean;



import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {

	@Id
	@GeneratedValue
	@JsonIgnore
	private int orderId;
	private String customerName;
	private int customerId;
	private double billAmount;
	@Enumerated(EnumType.STRING)
	private Payment paymentType;
	
}
