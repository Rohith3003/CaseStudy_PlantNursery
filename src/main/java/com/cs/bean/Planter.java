package com.cs.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.Data;
/**
 * Represents Planter entity, contains all the attributes along with validations.
 */
@Entity
@Data
public class Planter {
	
	@Id
	@GeneratedValue
	private int planterId;// Auto generated unique value 
	
	@URL(message="Must be a valid photo URL")
	private String photoLoc;//Url of the image
	
	@NotEmpty(message = "Planter name can't be empty")
	@Size(min=5,message = "Planter name should be min 5 character")
	@Pattern(regexp = "[a-zA-Z[\\s]]{5,50}",message = "Planter name should not have any digit or special character")
	private String name; //Signifies more details of the product like color,size,model etc. Eg. Brown M plain
	
	private Type category; //Belongs to one of the pre-defined Enum Type
	
	@NotEmpty
	@Size(min=10,message = "Description should be atleast 10 char and maximum 30 chars")
	private String description;//Description of the product

	@Max(10000)
	@Min(100)
	private float price;//Price of the planter
}
