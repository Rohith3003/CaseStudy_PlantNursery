package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Represents Seed entity, contains all the attributes along with validations.
 * @author- Palak
 */
@Entity
@Data
public class Seed {

	@Id
	@GeneratedValue
	private int seedId; //Takes Seed Id which is unique.
	
	@NotEmpty
	@Size(min=4, message="Seed name should have atleast 4 characters")
	private String name; //Takes name of the seed eg. Sunflower Seeds
	
	@URL(message="Must be a valid photo URL")
	private String photoLoc;//Url of the image

	@NotNull
	@Min(10)
	private double price;//Stores price of the seed in double precision
	
	@NotNull
	@Min(20)
	private int numberOfSeeds;//Stores number of seeds
	
	private String description;//Stores description of the screen.

	
	public Seed() {
		//Default Constructor
	}


	public Seed(int seedId,
			@NotEmpty @Size(min = 4, message = "Seed name should have atleast 4 characters") String name,
			@URL(message = "Must be a valid photo URL") String photoLoc, @NotNull @Min(10) double price,
			@NotNull @Min(20) int numberOfSeeds, String description) {
		super();
		this.seedId = seedId;
		this.name = name;
		this.photoLoc = photoLoc;
		this.price = price;
		this.numberOfSeeds = numberOfSeeds;
		this.description = description;
	}

}