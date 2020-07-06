package com.bank.bankapplication.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bank.bankapplication.dto.AccountDto;
import com.bank.bankapplication.dto.CustomerDto;
import com.bank.bankapplication.dto.TransactionDto;
import com.bank.bankapplication.entity.Account;
import com.bank.bankapplication.entity.Customer;
import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.repository.AccountRepository;
import com.bank.bankapplication.repository.TransactionRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transRepo;
	TransactionService transService;
	
	public Account generateAccount(Integer CustId){
		
		Account account = new Account();
		account.setAccountNo(generateRandom());
		account.setAccount_type("Saving Account");
		account.setAvailable_Balance(new Long(10000));
		account.setCust_id(CustId);
		return accountRepository.save(account);
	}
	
	public static long generateRandom() {
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();

	    // first not 0 digit
	    sb.append(random.nextInt(9) + 1);

	    // rest of 11 digits
	    for (int i = 0; i < 11; i++) {
	        sb.append(random.nextInt(10));
	    }

	    return Long.valueOf(sb.toString()).longValue();
	}
	
	
	public void transferAmount( Long fromAccount , Long toAccount, Long amount){
		
		Account ac = new Account();
		ac =  accountRepository.findByAccountNo(fromAccount	);
		long subtractExact = Math.subtractExact(ac.getAvailable_Balance(), amount);
		System.out.println(subtractExact);
		ac.setAvailable_Balance(subtractExact);
		accountRepository.save(ac);
		
		ac =  accountRepository.findByAccountNo(toAccount);
		ac.setAvailable_Balance(Math.addExact(ac.getAvailable_Balance(), amount));
		accountRepository.save(ac);
		
		Transaction trans = new Transaction();
		trans.setAmount(amount);
		trans.setDate(new Date(getCurrentDate()));
		trans.setFromAccount(fromAccount);
		trans.setToAccount(toAccount);
		trans.setTran_type("Debited");
		transRepo.save(trans);
		
		
	}
	
	public String getCurrentDate(){
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		 Date dateobj = new Date();
		return(df.format(dateobj));
		  
	}
	
	

}
