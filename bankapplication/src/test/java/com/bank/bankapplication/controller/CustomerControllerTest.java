package com.bank.bankapplication.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;

import com.bank.bankapplication.dto.CustomerDto;
import com.bank.bankapplication.entity.Customer;
import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.repository.CustomerRepository;
import com.bank.bankapplication.service.AccountService;
import com.bank.bankapplication.service.CustomerService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerControllerTest {

	@InjectMocks
	CustomerController customerController;
	
	@Mock
	CustomerService customerService;
	@Mock
	AccountService accountService;
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	public void testRegistration(){
		
		CustomerDto custdto = new CustomerDto();
		custdto.setAcountType("saving");
		custdto.setEmail("sona@s.com");
		custdto.setName("sona");
		custdto.setPassword("sona");
		custdto.setPhone(new Long("9876787678"));
		custdto.setUsername("sona");
		Customer cust = new Customer();
		
		BeanUtils.copyProperties(custdto, cust);
		
		Mockito.when(customerService.saveCustomer(custdto)).thenReturn(cust);
		ResponseEntity<String> registeration = customerController.registeration(custdto);
		Assert.assertNotNull(registeration);
		System.out.println(registeration.getBody());
		Assert.assertEquals("Congatulation..! Account created Successfully",registeration.getBody() );
	}
	
	@Test
	public void testTransfer(){
		
		Transaction trans = new Transaction();
		Mockito.when(accountService.transferAmount(new Long(123456), new Long(123456), new Long(1000))).thenReturn(trans);
		ResponseEntity<String> registeration = customerController.transfer(new Long(123456), new Long(123456), new Long(1000));
		Assert.assertNotNull(registeration);
		System.out.println(registeration.getBody());
		Assert.assertEquals("Amount tranfer Successfully",registeration.getBody() );
	}
}
