package com.it15301.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDTO {
	Integer id;
	
	@NotNull
	private Double price;

	@NotNull
	private Integer quantity;

	@NotNull
	private Integer productid;
	
	@NotNull
	private Integer order;

}
