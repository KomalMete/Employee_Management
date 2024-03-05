package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.LoginDTO;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public ResponseEntity<?> getAllEmployee()
	{
		return new ResponseEntity<>(empService.getAllEmployee(), HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{
		return new ResponseEntity<>(empService.addEmployee(emp), HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteEmplyoee(@PathVariable int id)
	{
		return new ResponseEntity<>(empService.deleteEmplyee(id), HttpStatus.OK);
	}
	
	@PutMapping("/editemp")
	public ResponseEntity<?> editEmplyee(@RequestBody Employee emp)
	{
		return new ResponseEntity<>(empService.editEmployee(emp), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO logindto)
	{
		return new ResponseEntity<>(empService.loginEmployee(logindto), HttpStatus.OK);
	}
}
