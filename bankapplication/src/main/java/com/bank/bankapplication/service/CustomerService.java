package com.bank.bankapplication.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankapplication.dto.CustomerDto;
import com.bank.bankapplication.entity.Customer;
import com.bank.bankapplication.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository custrepo;
	
	
	public Customer saveCustomer(CustomerDto custdto){
		
		Customer cust = new Customer();
		BeanUtils.copyProperties(custdto, cust);
		return custrepo.save(cust);
	}
}
