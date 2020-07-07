package com.bank.bankapplication.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.bank.bankapplication.dto.TransactionDto;
import com.bank.bankapplication.exception.UserNotFoundException;
import com.bank.bankapplication.service.TransactionService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TransactionControllerTest {

	@InjectMocks
	TransactionController transactionController;
	
	@Mock
	TransactionService transService;
	@Test
	public void testgetTransactionDetails()throws UserNotFoundException{
		List<TransactionDto> transDto = new ArrayList<TransactionDto>();
		
		Mockito.when(transService.gettransaction(new Long(23456678))).thenReturn(transDto);
		ResponseEntity<List<TransactionDto>> transactionDetails = transactionController.getTransactionDetails(new Long(23456678));
		
		Assert.assertNotNull(transactionDetails);
		System.out.println(transactionDetails.getStatusCode());
		Assert.assertEquals(200,transactionDetails.getStatusCodeValue());
		
	}
}
