package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.LoginDTO;
import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeServiceImple implements EmployeeService{

	
	@Autowired
	private EmployeeRepository empRepo;
	
	@Override
	public List<Employee> getAllEmployee() {
		
		return empRepo.findAll();
	}

	@Override
	public String addEmployee(Employee emp) {
		empRepo.save(emp);
		return "Employee Added Successfully...";
	}

	@Override
	public String deleteEmplyee(int id) {
		empRepo.deleteById(id);
		return "Employee Removed Successfully..";
	}

	@Override
	public String editEmployee(Employee emp) {
		
		empRepo.save(emp);
		return "Employee Details Updated Successfully..";
	}

	@Override
	public String loginEmployee(LoginDTO logindto) {
		Employee emp = empRepo.findByEmailAndPassword(logindto.getEmail(), logindto.getPassword());
		
		return "Login Successfull...";
	}
	

}
