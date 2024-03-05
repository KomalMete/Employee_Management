package com.example.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {

	@Column(length = 25,unique = true)
	@Email
	@NotEmpty(message = "email cannot be null")
	private String email;
	
	@Column(length = 9)
	@NotEmpty(message = "password required")
	private String password;
}
