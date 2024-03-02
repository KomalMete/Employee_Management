package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DeptDTO;
import com.example.entity.Department;
import com.example.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public String addDepartment(Department dept)
	{
			deptRepo.save(dept);
			return "Department added successfully";
	}

	@Override
	public String editDepartment(Department dept)
	{
		deptRepo.save(dept);
		return "Department details edited successfully...";
	}

	@Override
	public String deleteDepartment(int id)
	{
		deptRepo.deleteById(id);
		return "Department deleted successfully";
	}

	@Override
	public List<Department> getAllDepartments() {
		
		return deptRepo.findAll();
	}
	
	

}
