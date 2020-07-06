package com.bank.bankapplication.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.bank.bankapplication.dto.CustomerDto;
import com.bank.bankapplication.entity.Customer;
import com.bank.bankapplication.repository.CustomerRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CustomerServiceTest {

	@InjectMocks
	CustomerService customerService;
	
	@Mock
	CustomerRepository customerRepository;
	
	@Test
	public void testsave(){
		
		Customer cust = new Customer();
		CustomerDto custdto = new CustomerDto();
		custdto.setAcountType("saving");
		custdto.setEmail("sona@s.com");
		custdto.setName("sona");
		custdto.setPassword("sona");
		custdto.setPhone(new Long("9876787678"));
		custdto.setUsername("sona");
		BeanUtils.copyProperties(custdto, cust);
		
		
		Mockito.when(customerRepository.save(cust)).thenReturn(cust);
		
		customerService.save(custdto);
		System.out.println(cust.getUsername());
		Assert.assertNotNull(cust);
		Assert.assertEquals("sona", cust.getUsername());
		
		/*cust.setEmail("sona@s.com");
		cust.setName("sona");
		cust.setPassword("sona");
		cust.setPhone(new Long("9876787678"));
		cust.setUsername("sona");*/
		
		//return custrepo.save(cust);
		
	}
	
}
