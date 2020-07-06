package com.bank.bankapplication.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.bankapplication.entity.Account;
import com.bank.bankapplication.repository.AccountRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceTest {
	
	@InjectMocks
	AccountService accountService;

	@Mock
	AccountRepository accountRepository;
	
	@Test
	public void testgenerateAccount(){
		
		Account account = new Account();
		account.setAccountNo(accountService.generateRandom());
		account.setAccount_type("Saving Account");
		account.setAvailable_Balance(new Long(10000));
		account.setCust_id(2);
		accountService.generateAccount(2);
		//Mockito.when(accountRepository.save(account)).thenReturn(account);
		Assert.assertNotNull(account);
		Assert.assertEquals("Saving Account", account.getAccount_type());
		
	}
	
	@Test
	@Ignore
	public void testTranferamount(){
		Account account = new Account();
		account.setAccount_id(3);
		account.setAccountNo(new Long(978678987));
		account.setAccount_type("Saving Account");
		account.setAvailable_Balance(new Long(10000));
		account.setCust_id(2);
		
		Mockito.when(accountRepository.findByAccountNo(account.getAccountNo())).thenReturn(account);
		
		accountService.transferAmount(new Long(123456789), new Long(123456789), new Long(1000));
		
		System.out.println(account.getAvailable_Balance());
		Assert.assertNotNull(account);
		
	}
}
