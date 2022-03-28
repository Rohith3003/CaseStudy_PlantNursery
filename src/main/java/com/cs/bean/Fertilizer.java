package com.cs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is regarding fertilizer entity. Consists of 6 members
 * fertilizerId, fertilizerName, fertilizerImage, fertilizerPrice,
 * fertilizerDescription and fertilizerQuantity
 * 
 * @author Rohith(Employee id: 46191986)
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Fertilizer {

	@Id
	@GeneratedValue
	private int fertilizerId;
	@NotBlank(message = "Fertilizer name should not be empty")
	private String fertilizerName;
	@NotBlank(message = "Fertilizer image cannot be blank")
	private String fertilizerImage;
	@Positive(message = "Price cannot be less than or equal to zero")
	private double fertilizerPrice;
	@NotEmpty(message = "Fertilizer description must not be empty")
	private String fertilizerDescription;
	@Pattern(regexp = "^[1-9][0-9]{0,1}KG", message = "Invalid quantity: quantity must be greater than zero and less than 100 and must be in KG")
	private String fertilizerQuantity;

}
