package com.bank.bankapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankapplication.dto.TransactionDto;
import com.bank.bankapplication.service.TransactionService;


@RestController
@RequestMapping("/transactions")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/statements")
	public ResponseEntity<List<TransactionDto>> getTransactionDetails(@RequestParam Long accountNo){
		
		List<TransactionDto> transdtos = transactionService.gettransaction(accountNo);
		return new ResponseEntity<List<TransactionDto>> (transdtos ,HttpStatus.OK );
	}
	
}
