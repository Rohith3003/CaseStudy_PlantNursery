package com.cs.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class is used as input data transfer object while updating price and quantity of given fertilizer. 
 * @author Rohith(Employee id: 46191986)
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FertilizerDto {

	double fertilizerPrice;
	String fertilizerQuantity;
}
