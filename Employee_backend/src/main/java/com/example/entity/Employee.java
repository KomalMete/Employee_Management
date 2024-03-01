package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@NotEmpty(message = "firstname cannot be empty")
	private String firstName;
	
	@Column(name = "last_name")
	@NotEmpty(message = "lastname cannot be empty")
	private String lastName;
	
	@Column(length = 25,unique = true)
	@Email
	@NotEmpty(message = "email cannot be null")
	private String email;
	
	@Column(length = 9)
	@NotEmpty(message = "password required")
	private String password;
	
	@Column(length = 10)
	@Size(min = 10,max = 10)
	private String phone;
	
	@ManyToOne
	@JoinColumn(name = "dept_id")
	private Department department;

	
}
