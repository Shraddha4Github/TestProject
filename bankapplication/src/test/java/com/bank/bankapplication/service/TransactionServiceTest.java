package com.bank.bankapplication.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.bank.bankapplication.dto.CustomerDto;
import com.bank.bankapplication.dto.TransactionDto;
import com.bank.bankapplication.entity.Customer;
import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.exception.UserNotFoundException;
import com.bank.bankapplication.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionServiceTest {

	@InjectMocks
	TransactionService transactionService;
	
	@Mock
	TransactionRepository transRepo;
	
	@Test
	public void testsave(){
		
		Transaction trans = new Transaction();
		TransactionDto transdto = new TransactionDto();
		trans.setAmount(new Long (10000));
		trans.setDate(new Date());
		trans.setFromAccount(new Long (89789878));
		trans.setToAccount(new Long (894449878));
		trans.setTran_type("Debited");
		BeanUtils.copyProperties(trans, transdto);
		
		Mockito.when(transRepo.save(trans)).thenReturn(trans);
		transactionService.saveTransaction(transdto);
		
		Assert.assertNotNull(transdto);
		Assert.assertEquals("Debited", transdto.getTran_type());
		
	
	}
	
	@Test
	public void testgettransaction() throws UserNotFoundException{
		
		Transaction trans = new Transaction();
		TransactionDto transdto = new TransactionDto();
		trans.setAmount(new Long (10000));
		trans.setDate(new Date());
		trans.setFromAccount(new Long (89789878));
		trans.setToAccount(new Long (894449878));
		trans.setTran_type("Debited");
		BeanUtils.copyProperties(trans, transdto);
		
		List<TransactionDto> transdtolist = new ArrayList<TransactionDto>();
		List<Transaction> translist = new ArrayList<Transaction>();
		transdtolist.add(transdto);
		translist.add(trans);
		Mockito.when(transRepo.findTop5ByFromAccountOrderByDateDesc(new Long (89789878))).thenReturn(translist);
		transdtolist = transactionService.gettransaction(new Long (89789878));
		Assert.assertNotNull(translist);
	//	System.out.println(translist.get(0).getFromAccount());
		Assert.assertEquals(new Long(89789878), translist.get(0).getFromAccount());
	}
}
