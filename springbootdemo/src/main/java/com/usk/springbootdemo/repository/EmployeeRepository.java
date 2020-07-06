package com.usk.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usk.springbootdemo.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByUserNameAndPassword(String username , String password);
	
	
	Employee findByUserName (String username);
	
	List<Employee> findByUserNameContainsOrderByUserNameAsc(String username);
}
