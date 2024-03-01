package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Department;
import com.example.service.DepartmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/dept")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addDepartment(@RequestBody Department dept)
	{
		return new ResponseEntity<>(deptService.addDepartment(dept), HttpStatus.OK);
		
	}
}