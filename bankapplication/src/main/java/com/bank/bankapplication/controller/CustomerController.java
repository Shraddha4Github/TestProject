package com.bank.bankapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankapplication.dto.CustomerDto;
import com.bank.bankapplication.entity.Customer;
import com.bank.bankapplication.service.AccountService;
import com.bank.bankapplication.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	AccountService accountService;
	
	@PostMapping("/register")
	public ResponseEntity<String> registeration(@RequestBody CustomerDto custdto){
		
		Customer customer = customerService.saveCustomer(custdto);
		accountService.generateAccount(customer.getId());
		return new ResponseEntity<String>("Congatulation..! Account created Successfully",HttpStatus.CREATED);
	}
	
	@PostMapping("/transfer")
	public ResponseEntity<String> transfer(@RequestParam long fromAccount , @RequestParam long toAccount, @RequestParam long amount){
		
		accountService.transferAmount(fromAccount, toAccount, amount);
		return new ResponseEntity<String>("Amount tranfer Successfully",HttpStatus.CREATED);
	}
	
}
