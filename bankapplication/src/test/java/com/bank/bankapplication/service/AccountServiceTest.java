package com.bank.bankapplication.service;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;

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
		account.setAccounttype("Saving Account");
		account.setAvailableBalance(new Long("10000"));
		account.setCustid(2);
		accountService.generateAccount(2);
		 Mockito.when(accountRepository.save(account)).thenReturn(account);
		Assert.assertNotNull(account);
		Assert.assertEquals("Saving Account", account.getAccounttype());
		
	}
	
	@Test	
	@Ignore
	public void testTranferamount(){
		Account account = new Account();
		account.setAccountid(3);
		account.setAccountNo(new Long(978678987));
		account.setAccounttype("Saving Account");
		account.setAvailableBalance(new Long("10000"));
		account.setCustid(2);
		
		Mockito.when(accountRepository.findByAccountNo(new Long(123456))).thenReturn(account);
		
		accountService.transferAmount(new Long(123456789), new Long(123456789), new Long(1000));
		
		System.out.println(account.getAvailableBalance());
		Assert.assertNotNull(account);
		
	}
}
