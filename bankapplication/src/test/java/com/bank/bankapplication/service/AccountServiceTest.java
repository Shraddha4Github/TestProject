package com.bank.bankapplication.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.bank.bankapplication.entity.Account;
import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.repository.AccountRepository;
import com.bank.bankapplication.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class AccountServiceTest {
	
	@InjectMocks
	AccountService accountService;

	@Mock
	AccountRepository accountRepository;
	@Mock
	TransactionRepository transRepository;
	
	@Test
	public void testgenerateAccount(){
		
		Account account = new Account();
		account.setAccountNo(new Long(978678987));
		account.setAccounttype("Saving Account");
		account.setAvailableBalance(new Long("10000"));
		account.setCustid(2);
		accountService.generateAccount(2);
		 Mockito.when(accountRepository.save(account)).thenReturn(account);
		Assert.assertNotNull(account);
		Assert.assertEquals("Saving Account", account.getAccounttype());
		
	}
	
	@Test	
	
	public void testTranferamount(){
		Account account = new Account();
		account.setAccountid(3);
		account.setAccountNo(new Long(123456789));
		account.setAccounttype("Saving Account");
		account.setAvailableBalance(new Long(1000));
		account.setCustid(2);
		
		Transaction trans = new Transaction();
		trans.setAmount(new Long(1000));
		trans.setDate(new Date());
		trans.setFromAccount(new Long(123456789));
		trans.setToAccount(new Long (894449878));
		trans.setTrantype("Debited");
		
		Mockito.when(accountRepository.findByAccountNo(new Long(123456789))).thenReturn(account);
		Mockito.when(transRepository.save(trans)).thenReturn(trans);
		
		Transaction transferAmount = accountService.transferAmount(new Long(123456789), new Long(123456789), new Long(1000));
		
		//System.out.println(account.getAvailableBalance());
		Assert.assertNotNull(transferAmount);
		Assert.assertNotNull(account);
		
	}
}
