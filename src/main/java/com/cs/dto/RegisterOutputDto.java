package com.cs.dto;

import com.cs.bean.Address;
import lombok.Data;

@Data
public class RegisterOutputDto {
	private String name;
	private String emailId;
	private String mobileNumber;
	private Integer cartId;
	private Address address;
}