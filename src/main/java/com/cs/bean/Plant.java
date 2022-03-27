package com.cs.bean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Plant {
	@Id
	@GeneratedValue
	private int plantId;
	
	@Size(min = 6, message = "plant name invalid")
	@NotEmpty(message = "Please enter plant name")
	private String name;
	
	@NotNull(message = "Please enter plant price")
	private double price;
	
	@Size(min = 8, message = "plant type invalid")
	@NotEmpty(message = "Please enter plant type")
	private String type;
	
	@Size(min = 8, message = "plant description invalid")
	@NotEmpty(message = "Please enter plant description")
	private String description;
}
