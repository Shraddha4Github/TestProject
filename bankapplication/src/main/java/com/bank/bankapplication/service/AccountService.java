package com.bank.bankapplication.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankapplication.entity.Account;
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
		account.setAccounttype("Saving Account");
		account.setAvailableBalance(new Long("10000"));
		account.setCustid(CustId);
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
	
	
	public Transaction transferAmount( Long fromAccount , Long toAccount, Long amount){
		
		
		Account ac  =  accountRepository.findByAccountNo(fromAccount);
		long subtractExact = Math.subtractExact(ac.getAvailableBalance(), amount);
		ac.setAvailableBalance(subtractExact);
		accountRepository.save(ac);
		
		ac =  accountRepository.findByAccountNo(toAccount);
		long addExact = Math.addExact(ac.getAvailableBalance(), amount);
		ac.setAvailableBalance(addExact);
		accountRepository.save(ac);
		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		 Date dateobj = new Date();
		
		Transaction trans = new Transaction();
		trans.setAmount(amount);
		trans.setDate(new Date(df.format(dateobj)));
		trans.setFromAccount(fromAccount);
		trans.setToAccount(toAccount);
		trans.setTrantype("Debited");
		transRepo.save(trans);
		return trans;
		
	}
	
	

}
