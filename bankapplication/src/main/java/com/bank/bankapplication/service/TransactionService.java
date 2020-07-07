package com.bank.bankapplication.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.bankapplication.dto.TransactionDto;
import com.bank.bankapplication.entity.Transaction;
import com.bank.bankapplication.exception.UserNotFoundException;
import com.bank.bankapplication.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository transRepo;
	
	public Transaction saveTransaction(TransactionDto transDto){
		
		Transaction trans = new Transaction();
		BeanUtils.copyProperties(transDto, trans);
		return transRepo.save(trans);
	}


	public List<TransactionDto> gettransaction(Long accountNo) throws UserNotFoundException{
	
		List<Transaction> translist = new ArrayList<Transaction>();
		translist = transRepo.findTop5ByFromAccountOrderByDateDesc(accountNo);
		
		if(translist != null) {
		List<TransactionDto> transDtoList = new ArrayList<>();
		
			for(Transaction trans : translist){
				
				DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
				trans.setDate(trans.getDate());
				
				TransactionDto trnasDto = new TransactionDto();
				BeanUtils.copyProperties(trans, trnasDto);
				transDtoList.add(trnasDto);
			}
			return transDtoList;
		}
		throw new UserNotFoundException("No any transaction from account:"+accountNo);
	}
	
}
