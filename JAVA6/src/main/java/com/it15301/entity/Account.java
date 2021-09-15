package com.it15301.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Accounts")
public class Account  implements Serializable{
	@Id
	@Column(name = "Username")
	String username;
	@Column(name = "Password")
	String password;
	@Column(name = "Fullname")
	String fullname;
	@Column(name = "Email")
	String email;
	@Column(name = "Photo")
	String photo;
	@Column(name = "Role")
	String Role;
//	@JsonIgnore
//	@OneToMany(mappedBy = "account")
//	List<Order> orders;
	
}
