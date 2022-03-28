package com.cs.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.cs.bean.Login;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
	@NotEmpty(message = "Field must not be Empty")
	@Pattern(regexp = "[a-zA-Z[\\s]]{3,50}",
			message = "Name should not have any digit or special character")
	private String name;
	private int cartId;
	private int addressId;
	private Login login;
}
