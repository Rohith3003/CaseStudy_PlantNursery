package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Seed {

	@Id
	@GeneratedValue
	private int seedId;
	
	@NotEmpty
	@Size(min=4, message="Seed name should have atleast 4 characters")
	private String name;
	
	//@URL(message="Must be a valid photo URL")
	private String photoLoc;//Url of the image
	
	@Size(min = 8, message = "plant type invalid")
	@NotEmpty(message = "Please enter plant type")
	private String type;
	
	@NotNull
	@Min(1)
	private double price;
	
	@NotNull
	@Min(1)
	private int numberOfSeeds;
	
	
	private String description;

	

	public void setName(String name) {
		this.name = name;
	}

	

	public int getNumberOfSeeds() {
		return numberOfSeeds;
	}



	public void setNumberOfSeeds(int numberOfSeeds) {
		this.numberOfSeeds = numberOfSeeds;
	}



	public int getSeedId() {
		return seedId;
	}

    public void setSeedId(int seedId) {
		this.seedId = seedId;
	}

	public String getName() {
		return name;
	}

	

	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public double getPrice() {
		return price;
	}

	

	public String getPhotoLoc() {
		return photoLoc;
	}



	public void setPhotoLoc(String photoLoc) {
		this.photoLoc = photoLoc;
	}



	public void setPrice(double price) {
		this.price = price;
	}


	public Seed(int seedId, String name, double price, int numberOfSeeds, String description, String type) {
		
		this.seedId = seedId;
		this.name = name;
		this.setPrice(price);
		this.numberOfSeeds = numberOfSeeds;
		this.setDescription(description);
	}
	public Seed() {
		
	}

}
