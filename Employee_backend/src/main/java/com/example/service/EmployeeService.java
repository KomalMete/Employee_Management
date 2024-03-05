package com.example.service;

import java.util.List;

import com.example.dto.LoginDTO;
import com.example.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	String addEmployee(Employee emp);

	String deleteEmplyee(int id);

	String editEmployee(Employee emp);

	String loginEmployee(LoginDTO logindto);

}
