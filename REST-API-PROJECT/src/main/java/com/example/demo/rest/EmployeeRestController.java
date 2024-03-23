package com.example.demo.rest;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	//inject EmployeeService using constructor injection
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	//expose "/employees" and return a list of employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{EmployeeId}")
	public Employee getEmployee(@PathVariable int EmployeeId) {
		
		 Employee theEmployee = employeeService.findById(EmployeeId);
		 
		 if(theEmployee == null) {
			 throw new RuntimeException("Employee id not found - "+EmployeeId);
		 }
		 
		 return theEmployee;
	}
	
	// add mapping for POST /employees - add new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		//also just in case they pass an id in JSON...set id to 0
		theEmployee.setId(0);
		
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	// add mapping for PUT /employees/ - update an existing employee
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	//add mapping for DELETE /employee/{employeeId} - delete employee
	
	@DeleteMapping("/employees/{EmployeeId}")
	public String deleteEmployee(@PathVariable int EmployeeId) {
		
		Employee tempEmployee = employeeService.findById(EmployeeId);
		
		//throw exception if null
		
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found - "+EmployeeId);
		}
		employeeService.deleteById(EmployeeId);
		
		return "Deleted employee id - " + EmployeeId;
	}
}
