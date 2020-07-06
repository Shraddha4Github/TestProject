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


	public List<TransactionDto> gettransaction(Long accountNo){
	
		List<Transaction> translist = new ArrayList<Transaction>();
		translist = transRepo.findTop5ByFromAccountOrderByDateDesc(accountNo);
		
		List<TransactionDto> transDtoList = new ArrayList<>();
		
		for(Transaction trans : translist){
			
			System.out.println("from Account :"+trans.getFromAccount());
			System.out.println("to Account :"+trans.getToAccount());
			DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
			System.out.println(trans.getDate());
			trans.setDate(trans.getDate());
			
			TransactionDto trnasDto = new TransactionDto();
			BeanUtils.copyProperties(trans, trnasDto);
			transDtoList.add(trnasDto);
		}
		return transDtoList;
		
}
}
