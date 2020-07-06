package com.usk.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.springbootdemo.dto.EmployeeDto;
import com.usk.springbootdemo.entity.Employee;
import com.usk.springbootdemo.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	EmployeeService empservice;
	
	@GetMapping("/pagination")
	public List<Employee> getEmployeeForPagination(@RequestParam int pageNumber, @RequestParam int pageSize){
		return empservice.getEmployeeForPagination(pageNumber, pageSize);
	}
	
	@GetMapping(" ")
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> empDtos = empservice.getAllEmployee();
		return new ResponseEntity<List<EmployeeDto>>(empDtos, HttpStatus.OK);
		//return empservice.getAllEmployee();
	}

	@GetMapping("/search")
	public List<Employee> searchEmployee(@RequestParam String userName){
		return empservice.searchEmployees(userName);
	}
	
	@GetMapping("/searchByName")
	public Employee searchEmployeeByName(@RequestParam String userName){
		return empservice.searchEmployeeByName(userName);
	}
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> registration(@RequestBody EmployeeDto emp){
		
		empservice.saveEmployee(emp);
		return new ResponseEntity<String>("Successfully saved",HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username ,@RequestParam String password){
		
		Employee emp  = empservice.login(username , password);
		if(emp == null){
			return new ResponseEntity<String>("Successfully Login",HttpStatus.CREATED);
			
		}else
		    return new ResponseEntity<String>(" Login failed",HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById (Integer id){
		 
		EmployeeDto employeeDto =  empservice.getById(id);
		return new ResponseEntity<EmployeeDto>(employeeDto, HttpStatus.OK);
	}
	
	@PostMapping("/{id}")
	public String update (@PathVariable Integer id ,@RequestBody Employee emp){
		 
		return empservice.updateEmployee(id, emp);
	}
	
	@DeleteMapping("/{id}")
	public String delete (Integer id){
		 
		return empservice.deleteEmployee(id);
	}
}
