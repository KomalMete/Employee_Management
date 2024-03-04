package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.entity.Department;
import com.example.service.DepartmentService;



@RestController
@RequestMapping("/dept")
@CrossOrigin(origins = "http://localhost:3000")
public class DepartmentController {

	@Autowired
	private DepartmentService deptService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addDepartment(@RequestBody Department dept)
	{
		return new ResponseEntity<>(deptService.addDepartment(dept), HttpStatus.OK);
		
	}
	
	@PutMapping("/edit")
	public ResponseEntity<?> editDepartment(@RequestBody Department dept)
	{
		return new ResponseEntity<>(deptService.editDepartment(dept), HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<?> deleteDepartment(@PathVariable int id)
	{
		return new ResponseEntity<>(deptService.deleteDepartment(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> getAllDepartments()
	{
		return new ResponseEntity<>(deptService.getAllDepartments(), HttpStatus.OK);
	}
	
	@GetMapping("/getdept/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable int id)
	{
		return new ResponseEntity<>(deptService.getDepartmentById(id), HttpStatus.OK);
	}
}
