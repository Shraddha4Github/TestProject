package com.usk.springbootdemo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.usk.springbootdemo.dto.EmployeeDto;
import com.usk.springbootdemo.entity.Employee;
import com.usk.springbootdemo.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepository;
	
	public List<Employee> getEmployeeForPagination(int pagenumber , int pagesize) {
		 Pageable pagable = PageRequest.of(pagenumber, pagesize, Sort.by(Sort.Direction.DESC, "userName"));
		return empRepository.findAll(pagable).getContent();
	}
	
	
	public List<EmployeeDto> getAllEmployee() {
		
			List<Employee> employees = empRepository.findAll(Sort.by(Sort.Direction.DESC, "userName"));
			List<EmployeeDto> empDtos = new ArrayList();
			for(Employee emp : employees){
				EmployeeDto empDto = new EmployeeDto();
				BeanUtils.copyProperties(emp, empDto);
				empDtos.add(empDto);
			}
			return empDtos;
		
		
		//return userRepository.findAll();
		//return empRepository.findAll(Sort.by(Sort.Direction.DESC, "userName"));
	}
	
	public Employee searchEmployeeByName(String username){
		
		return empRepository.findByUserName(username);
	}
	
	
	public List<Employee> searchEmployees(String username){
		
		return empRepository.findByUserNameContainsOrderByUserNameAsc(username);
	}
	
	// Delete Employee
	public String deleteEmployee(Integer id){
		Optional<Employee> emp =  empRepository.findById(id);
		if(emp.isPresent()){
			empRepository.delete(emp.get());
			return "Employee deleted successfully";
		}
		else {
			return "Employee not found ";
		}
	}
	

	public String updateEmployee(Integer id, Employee e){
		Optional<Employee> emp =  empRepository.findById(id);
		if(emp.isPresent()){
			e.setId(id);
			empRepository.save(e);
			return "Employee updated successfully";
		}
		else {
			return "Employee not found ";
		}
	}
	
	
	public Employee saveEmployee(EmployeeDto e){
		Employee emp = new Employee();
		BeanUtils.copyProperties(e, emp);
		return empRepository.save(emp);
	}
	
	public Employee login (String username , String password){
		
		return empRepository.findByUserNameAndPassword(username, password);
		
	}
	
	public EmployeeDto getById (Integer id){
		Optional<Employee> emp =  empRepository.findById(id);
		if(emp.isPresent()){
			Employee e =  emp.get();
			EmployeeDto empDto = new EmployeeDto();
			BeanUtils.copyProperties(emp, empDto);
			return empDto;
		}
		else
			return null;
	}
}
