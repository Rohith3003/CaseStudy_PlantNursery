package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.URL;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GardenDecor
{
	@Id
	@GeneratedValue
	private int gardenDecorId;
	@NotBlank(message="Name should not be blank")
	private String gardenDecorName;
	@URL(message="Must be a valid photo URL")
	private String gardenDecorImage;
	@Min(value=0, message="Price must be more than 0")
	private double gardenDecorPrice;
	@NotBlank(message="Description should not be blank")
	private String gardenDecorDescription;
	
}
