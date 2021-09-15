package com.it15301.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity @Table(name = "products")
public class Product  implements Serializable{
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "Name")
	private String name;
	@Column(name = "Image")
	private String image;
	@Column(name = "Price")
	private Double price;
	@Temporal(TemporalType.DATE)
	@Column(name = "CreateDate")
	private Date createDate= new Date();
	@JoinColumn(name = "Available")
	private Boolean available;
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	private Category categoryId;
	@JsonIgnore
	@OneToMany(mappedBy = "productid")
	private List<OrderDetail> orderDetails;	
}
