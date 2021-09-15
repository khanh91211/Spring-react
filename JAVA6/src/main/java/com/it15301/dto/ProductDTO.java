package com.it15301.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Integer id;
	
	@NotNull
	@NotBlank
	private String name;

	@NotNull
	@NotBlank
	private String image;

	@NotNull
	private Integer price;
	
	@NotNull
	private Date createDate;
	
	@NotNull
	private Boolean available;
	
	@NotNull
	private Integer categoryId;

}
